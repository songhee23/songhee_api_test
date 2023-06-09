package com.songhee.demo.common.code;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

	// Common
	INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST.value(), "EC0001", "Invalid Input Value",
		"입력값을 확인해 주세요."),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), "EC0002", "Method Not Allowed",
		"요청 http method(get, post, put, delete)를 확인해 주세요."),
	ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "EC0003", "Entity Not Found", ""),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "EC0004", "Server Error", ""),
	INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST.value(), "EC0005", "Invalid Type Value", ""),
	HANDLE_ACCESS_DENIED(HttpStatus.SERVICE_UNAVAILABLE.value(), "EC0006", "Access is Denied", ""),

	// Business
	NO_SEARCHED_BLOG(HttpStatus.BAD_REQUEST.value(), "EB0001", "검색된 블로그가 없습니다.", ""),
	NO_CONVERT_TO_TIMESTAMP(HttpStatus.BAD_REQUEST.value(), "EB0002", "파싱할 수 없는 날짜 입니다.", "");

	private final String code;
	private final String message;
	private int status;
	private String solution;

	ErrorCode(final int status, final String code, final String message, final String solution) {
		this.status = status;
		this.message = message;
		this.code = code;
		this.solution = solution;
	}

	public String getMessage() {
		return this.message;
	}

	public String getCode() {
		return code;
	}

	public int getStatus() {
		return status;
	}

	public String getSolution() {
		return solution;
	}
}
