/*package com.connectivity.vikray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.entity.Task;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.serviceImpl.TaskServiceImpl;

@Service("TaskService")
public class TaskService {

	@Autowired
	TaskServiceImpl taskServiceImpl;

	@Autowired
	ValidResult result;

	public ValidResult getAllTask() {
		result.data = taskServiceImpl.getAllTask();
		result.ErrorCode = (long) 101;
		result.ErrorMsg = VikrayPmoMessageConstant.KEY_101;
		return result;
	}

	public ValidResult createTask(Task task) {
		Task ct = taskServiceImpl.createTask(task);
		if (ct != null) {
			result.ErrorCode = (long) 101;
			result.ErrorMsg = VikrayPmoMessageConstant.KEY_101;
			result.data = ct;
		} else {
			result.ErrorCode = (long) 102;
			result.ErrorMsg = VikrayPmoMessageConstant.KEY_102;
		}
		return result;
	}

	public ValidResult updateTask(Task task) {
		Object rt = taskServiceImpl.updateTask(task);
		if (rt != null) {
			result.ErrorCode = (long) 101;
			result.ErrorMsg = VikrayPmoMessageConstant.KEY_101;
			result.data = rt;
		} else {
			result.ErrorCode = (long) 102;
			result.ErrorMsg = VikrayPmoMessageConstant.KEY_102;
		}
		return result;
	}

}
*/