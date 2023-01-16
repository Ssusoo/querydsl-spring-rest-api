package me.ssu.querydslspringrestapi.domains.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberSignUp {

	@Getter
	public class Request {
		private List<Terms> terms;

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
		@Length(min = 8, max = 20)
		@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$",
				message = "비밀번호는 영문, 숫자, 특수문자로 조합해주세요.")
		@Schema(defaultValue = "hotmmx123**", description = "회원_비밀번호")
		private String memberPassword;

		@NotBlank
		@NotEmpty
		@Length(min = 8, max = 50)
		@Schema(defaultValue = "hotmmx123**", description = "체크_회원_비밀번호")
		private String checkMemberPassword;

		@Schema(defaultValue = "1988-08-08", description = "생년월일")
		private LocalDateTime birthDate;

		@Schema(defaultValue = "남", description = "회원_성별_플래그")
		private String memberGenderFlag;

		@Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$",
				message = "10~11 자리의 숫자만 입력 가능합니다.")
		@Schema(defaultValue = "010-123-1234", description = "회원_모바일_전화번호")
		private String memberMobileTelephoneNumber;

		@Schema(defaultValue = "경기도 부천시", description = "기본_주소")
		private String basicAddress;

		@Schema(defaultValue = "우리집", description = "상세_주소")
		private String detailAddress;

		@Schema(defaultValue = "123040", description = "우편번호")
		private String zipcode;
	}

	@Getter
	@AllArgsConstructor(access = AccessLevel.PUBLIC)
	public static class Terms {
		@Schema(defaultValue = "TERMS00001", description = "약관_코드")
		private String termsCode;

		@Schema(defaultValue = "1", description = "약관_회차_번호")
		private Integer termsTurnOrderNo;

		@Schema(defaultValue = "Y", description = "동의_여부")
		private String agreementYn;

		@Schema(defaultValue = "Y", description = "약관_동의_여부")
		private String termsAgreementYn;

		@Schema(defaultValue = "HI080001", description = "약관_구분_공통_코드 - 필수, 선택")
		private String termsDivisionCommonCode;

		@Schema(defaultValue = "HI100001", description = "약관_노출_공통_코드 - 회원가입 사용 약관, 그외 부가적인 약관")
		private String termsExposureCommonCode;

		@Schema(defaultValue = "HI090001", description = "약관_종류_구분_코드(이용약관 / 개인정보 수집 및 이용 동의 / 개인정보 제3자 제공 동의 / 광고성 정보 수신 동의)")
		private String termsKindCommonCode;
	}
}