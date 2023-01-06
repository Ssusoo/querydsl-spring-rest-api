package me.ssu.querydslspringrestapi.domains.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpMember {

	@Getter
	public class Request {
		@Schema(defaultValue = "test@naver.com", description = "회원_이메일")
		private String memberEmail;

		@Schema(defaultValue = "김테스트", description = "회원_이름")
		private String memberName;
		@Schema(defaultValue = "hotmmx123**", description = "회원_비밀번호")
		private String memberPassword;

		@Schema(defaultValue = "hotmmx123**", description = "체크_회원_비밀번호")
		private String checkMemberPassword;

		@Schema(defaultValue = "1988-08-08", description = "생년월일")
		private Date birthDate;

		@Schema(defaultValue = "남", description = "회원_성별_플래그")
		private String memberGenderFlag;

		@Schema(defaultValue = "010-123-1234", description = "회원_모바일_전화번호")
		private String memberMobileTelephoneNumber;

		@Schema(defaultValue = "경기도 부천시", description = "기본_주소")
		private String basicAddress;

		@Schema(defaultValue = "우리집", description = "상세_주소")
		private String detailAddress;

		@Schema(defaultValue = "123040", description = "우편번호")
		private String zipcode;

		public Request(String memberEmail, String memberName, String memberPassword, String checkMemberPassword,
		               Date birthDate, String memberGenderFlag, String memberMobileTelephoneNumber,
		               String basicAddress, String detailAddress, String zipcode) {
			this.memberEmail = memberEmail;
			this.memberName = memberName;
			this.memberPassword = memberPassword;
			this.checkMemberPassword = checkMemberPassword;
			this.birthDate = birthDate;
			this.memberGenderFlag = memberGenderFlag;
			this.memberMobileTelephoneNumber = memberMobileTelephoneNumber;
			this.basicAddress = basicAddress;
			this.detailAddress = detailAddress;
			this.zipcode = zipcode;
		}
	}
}