package me.ssu.querydslspringrestapi.base.controller;

import me.ssu.querydslspringrestapi.config.util.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseController {

	/**
	 * 정상 (200) 응답 (결과 데이터 없음)
	 */
	public ApiResponse<Object> responseJson() {
		return responseJson(null);
	}

	/**
	 * 정상 (200) 응답 (결과 데이터 포함)
	 * @param data : API 결과 데이터 컬렉션, 모델 ...
	 */
	public <T> ApiResponse<T> responseJson(T data) {
		return (ApiResponse<T>) ApiResponse.builder()
				.data(data)
				.build();
	}
}