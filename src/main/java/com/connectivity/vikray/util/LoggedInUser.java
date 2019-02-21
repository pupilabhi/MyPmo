package com.connectivity.vikray.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.jwt.UserPrincipal;

@Service
public class LoggedInUser {

	public static Long getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserPrincipal userPricipal = null;
        if (authentication != null) {
            	userPricipal = ((UserPrincipal) authentication.getPrincipal());
        }
        Long l = userPricipal.getId();
        return userPricipal.getId();
	}
}
