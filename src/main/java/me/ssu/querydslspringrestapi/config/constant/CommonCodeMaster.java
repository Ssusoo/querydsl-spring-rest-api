package me.ssu.querydslspringrestapi.config.constant;

import lombok.Getter;

@Getter
public enum CommonCodeMaster {
	MEET_QUESTION_STATUS("SA01", "sampleCode", ""),

	;

	private final String code; // 마스터 코드
	private final String codeField; // 코드 필드 명 (=해당 코드를 사용하는 entity 의 멤버 변수 명)
	private final String parentCode; // 부모 마스터 코드

	CommonCodeMaster(String code, String codeField, String parentCode) {
		this.code = code;
		this.codeField = codeField;
		this.parentCode = parentCode;
	}
}