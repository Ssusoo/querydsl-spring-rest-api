package me.ssu.querydslspringrestapi.config.error;

import me.ssu.querydslspringrestapi.config.constant.ApiResponseCode;

public class JwtTokenMissingException extends BusinessException {

	public JwtTokenMissingException() {
		super(ApiResponseCode.INVALID_TOKEN);
	}
}
