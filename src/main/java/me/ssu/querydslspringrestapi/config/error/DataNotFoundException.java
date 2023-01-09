package me.ssu.querydslspringrestapi.config.error;

import me.ssu.querydslspringrestapi.config.constant.ApiResponseCode;

public class DataNotFoundException extends BusinessException {

	public DataNotFoundException() {
		super(ApiResponseCode.DATA_NOT_FOUND);
	}

	public DataNotFoundException(String message) {
		super(ApiResponseCode.DATA_NOT_FOUND, message);
	}
}
