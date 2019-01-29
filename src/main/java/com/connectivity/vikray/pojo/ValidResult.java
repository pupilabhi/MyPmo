package com.connectivity.vikray.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Component
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ValidResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Long ErrorCode;
	public String ErrorMsg;
	public Object data;
	
	
	/*public Long getErrorCode() {
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
	}*/
	
	
}
