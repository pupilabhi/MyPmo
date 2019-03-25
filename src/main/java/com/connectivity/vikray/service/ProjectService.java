package com.connectivity.vikray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.Project;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.serviceImpl.ProjectServiceImpl;


@Service("ProjectService")
public class ProjectService {

	@Autowired
	ProjectServiceImpl projectServiceImpl;

	@Autowired
	ValidResult result;

	public ResponseEntity<ApiResponse> createProject(Project project) {
		ResponseEntity<ApiResponse> response = projectServiceImpl.createProject(project);
		return response;
	}

	public ResponseEntity<ApiResponse> updateProject(Project project) {
		 ResponseEntity<ApiResponse> response = projectServiceImpl.updateProject(project);
		 return response;
		
	}

	public ResponseEntity<Resources<?>> getAllProject() {
		ResponseEntity<Resources<?>> response =	projectServiceImpl.getAllProject();
		return response;
	}

	public ResponseEntity<ApiResponse> getProjectById(Long id) {
		ResponseEntity<ApiResponse> response = projectServiceImpl.getProjectById(id);
		return response;
	}
	public ValidResult getAllUserList() {
		result.setData(projectServiceImpl.getAllUsersList());
		result.setErrorCode((long) 101);
		result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
		return result;
	}
	
}
