package me.ssu.querydslspringrestapi.domains.terms.domain;

import lombok.*;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberMaster;
import me.ssu.querydslspringrestapi.domains.member.dto.SignUpMember;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ssu_terms_agrmt_hist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class TermsAgreementHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "terms_agrmt_hist_serlno", nullable = false, updatable = false)
	private Long termsAgreementHistorySerialNo; // 약관_동의_이력_일련번호

	// 회원 Entity 생성 후 주석 해제
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "mem_serlno", nullable = false, updatable = false,
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private MemberMaster memberMaster; // 회원_일련번호

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns(value = {
			@JoinColumn(name = "terms_cd", nullable = false, updatable = false),
			@JoinColumn(name = "terms_turn_ord_no", nullable = false, updatable = false)
	}, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Terms terms;

	@Column(name = "terms_agrmt_yn")
	private String termsAgreementYn; // 약관_동의_여부

	@CreatedDate
	@Column(name = "reg_dtm", nullable = false)
	private LocalDateTime registerAt; // 등록_일시

	/**
	 * 약관_동의_이력(회원가입) 저장
	 * @param newMember
	 * @param terms
	 * @param termsAgreementYn
	 * @return
	 */
	public static TermsAgreementHistory create(MemberMaster newMember, Terms terms, String termsAgreementYn) {
		return TermsAgreementHistory.builder()
				.memberMaster(newMember)
				.terms(terms)
				.termsAgreementYn(termsAgreementYn)
				.build();
	}
}