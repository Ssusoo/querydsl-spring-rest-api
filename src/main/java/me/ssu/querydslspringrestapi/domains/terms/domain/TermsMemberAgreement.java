package me.ssu.querydslspringrestapi.domains.terms.domain;

import lombok.*;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberMaster;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ssu_terms_mem_agrmt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class TermsMemberAgreement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "terms_agrmt_serlno", nullable = false, updatable = false)
	private Long termsAgreementSerialNo; // 약관 동의 일련번호

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

	@Column(name = "agrmt_yn", nullable = false)
	private String agreementYn; // 약관 동의 여부

	@CreatedDate
	@Column(name = "agrmt_dtm", nullable = false)
	private LocalDateTime agreementAt; // 동의 일시

	/**
	 * 약관_동의_이력(회원가입) 저장
	 * @param newMember
	 * @param terms
	 * @param agreementYn
	 * @return
	 */
	public static TermsMemberAgreement create(MemberMaster newMember, Terms terms, String agreementYn) {
		return TermsMemberAgreement.builder()
				.memberMaster(newMember)
				.terms(terms)
				.agreementYn(agreementYn)
				.build();
	}
}