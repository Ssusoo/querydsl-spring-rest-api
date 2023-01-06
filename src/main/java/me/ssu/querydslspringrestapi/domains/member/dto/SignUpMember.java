package me.ssu.querydslspringrestapi.domains.member.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpMember {

	@Getter
	public class Request {
		// 회원_이메일
		// 회원_이름
		// 비밀번호
		// 비밀번호 확인
		// 생년월일
		// 회원_성별_플래그
		// 회원 전화번호
		// 기본주소
		// 상세주소
		// 우편번호
	}
}
