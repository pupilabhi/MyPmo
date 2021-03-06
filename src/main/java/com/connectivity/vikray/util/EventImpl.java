package com.connectivity.vikray.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoConstant;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.repository.TaskRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;

@Service
public class EventImpl {

	@Autowired
	UserDetailsRepository userRepository;

	
	@Autowired 
	TaskRepository taskRepository;
	

	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);

	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
		// Load client secrets.
		InputStream in = EventImpl.class.getResourceAsStream(VikrayPmoConstant.CREDENTIALS_FILE_PATH);
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES)
						.setDataStoreFactory(
								new FileDataStoreFactory(new java.io.File(VikrayPmoConstant.TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}

	public void createEvent(Task task) throws GeneralSecurityException, IOException {
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(VikrayPmoConstant.APPLICATION_NAME).build();
		System.out.println("GOT CREDENTIALS...Proceeding to event >>" + getCredentials(HTTP_TRANSPORT));
		Event event = new Event().setSummary(task.getTaskName()).setLocation(task.getAccountAddress())
				.setDescription(task.getDescription());

		/* created Date will be start date of the event */
		DateTime startDateTime = new DateTime(task.getCreatedDate());
		EventDateTime start = new EventDateTime().setDateTime(startDateTime).setTimeZone("Asia/Kolkata");
		event.setStart(start);

		/* Due Date Will be end Date of the task */
		DateTime endDateTime = new DateTime(task.getDueDate());
		EventDateTime end = new EventDateTime().setDateTime(endDateTime).setTimeZone("Asia/Kolkata");
		event.setEnd(end);

		String[] recurrence = new String[] { "RRULE:FREQ=DAILY;COUNT=2" };
		event.setRecurrence(Arrays.asList(recurrence));
		UserDetails user;
		if (task.getAssignee() != null) {
			user = userRepository.getOne(task.getAssignee().getId());

		/*
		 * First EventAttendee is organizer and after all are the Participant(),
		 * AssigneeUserFk will be participant
		 */
		EventAttendee[] attendees = new EventAttendee[] { 
				new EventAttendee().setEmail(user.getUserEmail()),
				new EventAttendee().setEmail(task.getAssignee().getUserEmail()), };
		event.setAttendees(Arrays.asList(attendees));

		EventReminder[] reminderOverrides = new EventReminder[] {
				new EventReminder().setMethod("email").setMinutes(24 * 60),
				new EventReminder().setMethod("popup").setMinutes(24 * 60), };
		Event.Reminders reminders = new Event.Reminders().setUseDefault(false)
				.setOverrides(Arrays.asList(reminderOverrides));
		event.setReminders(reminders);
		}
		
		String calendarId = "primary";
		event = service.events().insert(calendarId, event).execute();
//		String evur = event.getHtmlLink();
		task.setEventId(event.getId());
		taskRepository.save(task);
	}

	public void updateEvent(Task taskfromDb) throws GeneralSecurityException, IOException {
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
				.setApplicationName(VikrayPmoConstant.APPLICATION_NAME).build();
		Event event = service.events().get("primary", taskfromDb.getEventId()).execute();
		System.out.println("EVENT ID "+event.getId());
		event.setSummary(taskfromDb.getTaskName());
		event.setLocation(taskfromDb.getAccountAddress());
		event.setDescription(taskfromDb.getDescription());

		DateTime startDateTime = new DateTime(taskfromDb.getCreatedDate());
		EventDateTime start = new EventDateTime().setDateTime(startDateTime).setTimeZone("Asia/Kolkata");
		event.setStart(start);

		/* Due Date Will be end Date of the task */
		DateTime endDateTime = new DateTime(taskfromDb.getDueDate());
		EventDateTime end = new EventDateTime().setDateTime(endDateTime).setTimeZone("Asia/Kolkata");
		event.setEnd(end);

		// Update the event
		Event updatedEvent = service.events().update("primary", event.getId(), event).execute();

		System.out.println(updatedEvent.getUpdated());
	}

	public void createRecuringEvent() {

	}
}
