/*package com.connectivity.vikray.security;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.connectivity.vikray.repository.LoginRepository;


public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	LoginRepository loginRepo; 
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		
		// Let people login with either username or email
        com.connectivity.vikray.entity.UserDetails user = 
        		loginRepo.findByUserLoginIdOrUserEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        );
        return UserPrincipal.create(user);
	}
	
    @Transactional
    public UserDetails loadUserById(Long id) {
        UserDetails user = loginRepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }
}
*/