package edu.eci.escuelaing.ieti.userapi.dto;

import org.springframework.http.HttpStatus;

import edu.eci.escuelaing.ieti.userapi.entities.enums.ErrorCodeEnum;

public  class  ServerErrorResponseDto {

	String  message;
	ErrorCodeEnum  errorCode;
	int  httpStatus;
	
	

	public ServerErrorResponseDto() {
	}
	public  ServerErrorResponseDto(String  message, ErrorCodeEnum  errorCode, HttpStatus  httpStatus) {
		this.message = message;
		this.errorCode = errorCode;
		this.httpStatus = httpStatus.value();
	}
	public  String  getMessage() {
		return  message;
	}
	
	public  ErrorCodeEnum  getErrorCode() {
		return  errorCode;
	}

	public  int  getHttpStatus() {
		return  httpStatus;
	}

}
