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
		Object cp= projectServiceImpl.createProject(project);
		if (cp != null) {
			result.ErrorCode = (long) 101;
			result.ErrorMsg = VikrayPmoMessageConstant.KEY_101;
			result.data = cp;
		} else {
			result.ErrorCode = (long) 102;
			result.ErrorMsg = VikrayPmoMessageConstant.KEY_102;
		}
		return result;
	}

	public ValidResult getAllProject() {
		result.data = projectServiceImpl.getAllProject();
		result.ErrorCode = (long) 101;
		result.ErrorMsg = VikrayPmoMessageConstant.KEY_101;
		return result;
	}

	/*public ValidResult getAllProject() {
		result.data = projectServiceImpl.getAllProject();
		result.ErrorCode = (long) 101;
		result.ErrorMsg = VikrayPmoMessageConstant.KEY_101;
		return result;
	}*/
}
