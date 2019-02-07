package com.connectivity.vikray.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.connectivity.vikray.entity.UserDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Component
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ValidResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Long ErrorCode;
	public String ErrorMsg;
	public Object data;
	public UserDetails user;
	
}
