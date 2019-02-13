package com.connectivity.vikray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.serviceImpl.ProjectServiceImpl;


@Service("ProjectService")
public class ProjectService {

	@Autowired
	ProjectServiceImpl projectServiceImpl;

	@Autowired
	ValidResult result;

	public ValidResult createProject(Project project) {
		Project cp = projectServiceImpl.createProject(project);
		if (cp != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(cp);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

	public ValidResult updateProject(Project project) {
		Object rt = projectServiceImpl.updateProject(project);
		if (rt != null) {
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(rt);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

	public ValidResult getAllProject() {
		result.setData(projectServiceImpl.getAllProject());
		result.setErrorCode((long) 101);
		result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
		return result;
	}

	public ValidResult getAllUserList() {
		result.setData(projectServiceImpl.getAllUsersList());
		result.setErrorCode((long) 101);
		result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
		return result;
	}

	public ValidResult getProjectById(Long id) {
		Object rt = projectServiceImpl.getProjectById(id);
		if (rt != null) {
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(rt);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}
}
