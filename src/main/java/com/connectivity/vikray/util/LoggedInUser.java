package com.connectivity.vikray.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.jwt.UserPrincipal;
import com.connectivity.vikray.repository.UserDetailsRepository;

@Service
public class LoggedInUser {

	@Autowired 
	UserDetailsRepository userDetailsRepository;
	
	
	public  UserDetails getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserPrincipal userPricipal = null;
        if (authentication != null) {
            	userPricipal = ((UserPrincipal) authentication.getPrincipal());
        }
        Long l = userPricipal.getId();
        return userDetailsRepository.getOne(l);
	}
}
