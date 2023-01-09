package me.ssu.querydslspringrestapi.domains.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.ssu.querydslspringrestapi.config.constant.CommonCodeMaster;
import me.ssu.querydslspringrestapi.domains.common.application.CommonCodesService;
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

		@Schema(defaultValue = "필수", description = "약관_구분_공통_코드_이름")
		private String termsDivisionCommonCodeName;

		@Schema(defaultValue = "HI100001", description = "약관_노출_공통_코드 - 회원가입 사용 약관, 그외 부가적인 약관")
		private String termsExposureCommonCode;

		@Schema(defaultValue = "회원가입 약관", description = "약관_노출_공통_코드_이름")
		private String termsExposureCommonCodeName;

		@Schema(defaultValue = "HI090001", description = "약관_종류_구분_코드(이용약관 / 개인정보 수집 및 이용 동의 / 개인정보 제3자 제공 동의 / 광고성 정보 수신 동의)")
		private String termsKindCommonCode;

		@Schema(defaultValue = "이용약관", description = "약관_종류_구분_코드_이름")
		private String termsKindCommonCodeName;

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
		private Date birthDate;

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

		public Request(String termsCode, Integer termsTurnOrderNo, String agreementYn,
		               String termsAgreementYn, String termsDivisionCommonCode,
		               String termsExposureCommonCode, String termsKindCommonCode,
		               String memberEmail, String memberName, String memberPassword,
		               String checkMemberPassword, Date birthDate, String memberGenderFlag,
		               String memberMobileTelephoneNumber, String basicAddress,
		               String detailAddress, String zipcode) {
			this.termsCode = termsCode;
			this.termsTurnOrderNo = termsTurnOrderNo;
			this.agreementYn = agreementYn;
			this.termsAgreementYn = termsAgreementYn;
			this.termsDivisionCommonCode = termsDivisionCommonCode;
			this.termsExposureCommonCode = termsExposureCommonCode;
			this.termsKindCommonCode = termsKindCommonCode;
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

			var commonCodes = CommonCodesService.getCommonCodes(
					new CommonCodeMaster[]{
							CommonCodeMaster.TERMS_DIVISION, // 약관_구분_공통_코드(필수/선택)
							CommonCodeMaster.TERMS_EXPOSURE, // 약관_노출_공통_코드(회원가입)
							CommonCodeMaster.TERMS_KIND, // 약관_종류_구분_코드_이름(이용약관)
					});

			this.termsDivisionCommonCodeName = CommonCodesService
					.getCodeName(commonCodes, CommonCodeMaster.TERMS_DIVISION, termsDivisionCommonCode);

			this.termsExposureCommonCodeName = CommonCodesService
					.getCodeName(commonCodes, CommonCodeMaster.TERMS_EXPOSURE, termsExposureCommonCode);

			this.termsKindCommonCodeName = CommonCodesService
					.getCodeName(commonCodes, CommonCodeMaster.TERMS_KIND, termsKindCommonCode);


		}
	}
}