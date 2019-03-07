package com.connectivity.vikray.controller;


import java.net.URI;
import java.util.Collections;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.connectivity.vikray.entity.Role;
import com.connectivity.vikray.entity.UserDetails;
import com.connectivity.vikray.exception.AppException;
import com.connectivity.vikray.jwt.JwtTokenProvider;
import com.connectivity.vikray.payload.ApiResponse;
import com.connectivity.vikray.payload.JwtAuthenticationResponse;
import com.connectivity.vikray.payload.LoginRequest;
import com.connectivity.vikray.payload.SignUpRequest;
import com.connectivity.vikray.pojo.RoleName;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.repository.RoleRepository;
import com.connectivity.vikray.repository.UserDetailsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/auth")
@Api(value = "Authentication API's" , description = "Authentication Related Apis, Won't require Access Token")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    
    @Autowired
    ValidResult result;

    @ApiOperation(value = "Returns Access Token" , notes= "Authenticate user based on userId and password"
    		+ " return the JWT token for accessing Auth API's ")
    @PostMapping("/signin")
    public ValidResult authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserLoginId(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        Optional<UserDetails> mem = userRepository.findByUserLoginId(loginRequest.getUserLoginId());
		result.setData(ResponseEntity.ok(new JwtAuthenticationResponse(jwt)));
		UserDetails m = mem.get();
		if(m!=null) {
			UserDetails user = userRepository.getOne(m.getId());
			result.setUser(user);
		}
        return result;
    }

    @ApiOperation(value="Register new user",
    		notes = "Validate duplicate user by userId and Email and returns registered user Object")
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUserLoginId(signUpRequest.getUserLoginId())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByUserEmail(signUpRequest.getUserEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        com.connectivity.vikray.entity.UserDetails user = new UserDetails(signUpRequest.getFirstName(), signUpRequest.getUserLoginId(),
                signUpRequest.getUserEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        com.connectivity.vikray.entity.UserDetails result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getFirstName()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
