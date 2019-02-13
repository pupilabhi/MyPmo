package com.connectivity.vikray.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.connectivity.vikray.entity.UserDetails;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Component
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ValidResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ErrorCode;
	private String ErrorMsg;
	private Object data;
	private UserDetails user;

	public Long getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(Long errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
}
