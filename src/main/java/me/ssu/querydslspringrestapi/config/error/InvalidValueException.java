package me.ssu.querydslspringrestapi.config.error;

import me.ssu.querydslspringrestapi.config.constant.ApiResponseCode;

public class InvalidValueException extends BusinessException {

	public InvalidValueException(String value) {
		super(ApiResponseCode.INVALID_INPUT_VALUE, value);
	}

	public InvalidValueException(String value, ApiResponseCode apiResponseCode) {
		super(apiResponseCode, value);
	}
}