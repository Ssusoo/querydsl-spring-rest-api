package me.ssu.querydslspringrestapi.domains.terms.domain;

import lombok.*;
import me.ssu.querydslspringrestapi.base.domain.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ssu_terms")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Terms extends BaseEntity {
	@Embeddable
	@AllArgsConstructor(access = AccessLevel.PROTECTED)
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@Getter
	@Builder
	@EqualsAndHashCode
	public static class TermsId implements Serializable {

		@Column(name = "terms_cd", length = 10, nullable = false, updatable = false)
		private String termsCode; // 약관_코드

		@Column(name = "terms_turn_ord_no", nullable = false, updatable = false)
		private Integer termsTurnOrderNo; // 약관_회차_번호
	}

	@EmbeddedId
	private Terms.TermsId termsId;

	@Column(name = "terms_div_comm_cd", nullable = false)
	private String termsDivisionCommonCode; // 약관_구분_공통_코드(필수, 선택)

	@Column(name = "terms_kind_comm_cd")
	private String termsKindCommonCode; // 약관_종류_구분_코드(이용약관 / 개인정보 수집 및 이용 동의 / 개인정보 제3자 제공 동의 / 광고성 정보 수신 동의)

	@Column(name = "terms_div_exposr_seq")
	private Integer termsDivisionExposureSequence; // 약관_구분_노출_순서(구분별 노출 순서)

	@Column(name = "terms_exposr_comm_cd", length = 8, nullable = false)
	private String termsExposureCommonCode; // 약관_노출_공통_코드(회원가입 사용 약관, 그외 부가적인 얀관)

	@Column(name = "terms_title", nullable = false, length = 200)
	private String termsTitle; // 약관_제목

	@Column(name = "terms_cont", nullable = false)
	private String termsContent; // 약관_내용

	@Column(name = "use_yn", nullable = false, length = 1)
	private String useYn; // 사용_여부

	@Column(name = "st_dtm", nullable = false)
	private LocalDateTime startAt; // 시작 일시

	@Column(name = "ed_dtm", nullable = false)
	private LocalDateTime endAt; // 종료 일시
}