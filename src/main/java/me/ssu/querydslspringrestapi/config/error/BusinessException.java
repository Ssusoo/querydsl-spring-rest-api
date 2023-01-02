package me.ssu.querydslspringrestapi.config.error;

import me.ssu.querydslspringrestapi.config.constant.ApiResponseCode;

public class BusinessException extends RuntimeException {

	private final ApiResponseCode apiResponseCode;
	private final String errorMessage;

	public BusinessException(ApiResponseCode apiResponseCode) {
		super(apiResponseCode.getMessage());
		this.apiResponseCode = apiResponseCode;
		this.errorMessage = apiResponseCode.getMessage();
	}

	public BusinessException(ApiResponseCode apiResponseCode, String message) {
		super(message);
		this.apiResponseCode = apiResponseCode;
		this.errorMessage = message;
	}

	public ApiResponseCode getErrorCode() {
		return apiResponseCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
