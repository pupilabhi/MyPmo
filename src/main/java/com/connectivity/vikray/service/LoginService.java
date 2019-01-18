/*package com.connectivity.vikray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.repository.LoginRepository;
import com.connectivity.vikray.serviceImpl.LoginServiceImpl;

import proj.pupils.constant.PupilsMessageConstant;
import proj.pupils.entity.Member;
import proj.pupils.jwt.JwtUtil;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@Autowired
	ValidResult validResult;
	
	public String login(UserDetails userDetails) {
		UserDetails p = loginServiceImpl.login(userDetails);
		if (p == null) {
			result.data = VikrayPmoMessageConstant.LOGIN_102; 
		} else {
			result.data = VikrayPmoMessageConstant.LOGIN_101;
		}
		return result;
	}
}
*/