package me.ssu.querydslspringrestapi.domains.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpMember {

	@Getter
	public class Request {

		@Email
		@NotBlank
		@NotEmpty
		@Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$",
				message = "이메일 형식에 맞게 입력해주세요.")
		@Schema(defaultValue = "test@naver.com", description = "회원_이메일")
		private String memberEmail;

		@NotEmpty
		@NotBlank
		@Schema(defaultValue = "김테스트", description = "회원_이름")
		private String memberName;

		@NotBlank
		@NotEmpty
		@Length(min = 8, max = 50)
		@Schema(defaultValue = "hotmmx123**", description = "회원_비밀번호")
		private String memberPassword;

		@NotBlank
		@NotEmpty
		@Length(min = 8, max = 50)
		@Schema(defaultValue = "hotmmx123**", description = "체크_회원_비밀번호")
		private String checkMemberPassword;

		@Schema(defaultValue = "1988-08-08", description = "생년월일")
		private Date birthDate;

		@Schema(defaultValue = "남", description = "회원_성별_플래그")
		private String memberGenderFlag;

		@Pattern(regexp = "^01((?:0|1|[6-9]))-(?:\\d{3}|\\d{4})-\\d{4}$",
				message = "올바른 전화번호를 입력해주세요.")
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