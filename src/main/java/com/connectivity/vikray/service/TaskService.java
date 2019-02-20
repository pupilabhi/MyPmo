package com.connectivity.vikray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.entity.TaskComment;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.serviceImpl.TaskServiceImpl;

@Service("TaskService")
public class TaskService {

	@Autowired
	TaskServiceImpl taskServiceImpl;

	@Autowired
	ValidResult result;

	public ValidResult getAllTask() {
		result.setData(taskServiceImpl.getAllTask());
		result.setErrorCode((long) 101);
		result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
		return result;
	}

	public ValidResult createTask(Task task) {
		Task ct = taskServiceImpl.createTask(task);
		if (ct != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(ct);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

	public ValidResult updateTask(Task task) {
		Object rt = taskServiceImpl.updateTask(task);
		if (rt != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(rt);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

	public ValidResult addTaskComments(TaskComment comments) {
		TaskComment comm= taskServiceImpl.addTaskComment(comments);
		if (comm != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(comm);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

	public ValidResult updateTaskComments(TaskComment comments) {
		Object tc= taskServiceImpl.updateTaskComment(comments);
		if (tc != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(tc);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

	public ValidResult getTaskById(Long id) {
		Object rt= taskServiceImpl.getTaskById(id);
		if (rt != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(rt);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

	public ValidResult getTaskBycreatorUser() {
		Object rt= taskServiceImpl.getTaskByCreatorUser();
		if (rt != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(rt);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

}
