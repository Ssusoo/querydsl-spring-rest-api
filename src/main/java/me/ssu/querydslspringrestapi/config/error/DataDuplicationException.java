package me.ssu.querydslspringrestapi.config.error;

import me.ssu.querydslspringrestapi.config.constant.ApiResponseCode;

public class DataDuplicationException extends BusinessException {

	public DataDuplicationException() {
		super(ApiResponseCode.DUPLICATION_ENTITY_DATA);
	}

	public DataDuplicationException(String message) {
		super(ApiResponseCode.DUPLICATION_ENTITY_DATA, message);
	}
}