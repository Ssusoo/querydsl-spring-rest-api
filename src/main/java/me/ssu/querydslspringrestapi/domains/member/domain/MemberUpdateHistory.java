package me.ssu.querydslspringrestapi.domains.member.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ssu_mem_upd_hist")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class MemberUpdateHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_upd_hist_serlno", nullable = false, updatable = false)
	private Long memberUpdateHistorySerialNo; // 회원_수정이력_일련번호

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "mem_serlno", nullable = false, updatable = false,
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private MemberMaster memberMaster; // 회원_일련번호

	@Column(name = "mem_email", length = 200, nullable = false)
	private String memberEmail; // 회원_이메일

	@Column(name = "mem_gndr_flag", length = 1)
	private String memberGenderFlag; // 회원_성별_플래그

	@Column(name = "mem_mobile_telno", length = 20)
	private String memberMobileTelephoneNumber; // 회원_모바일_전화번호

	@Column(name = "bas_addr", length = 200)
	private String basicAddress; // 기본_주소

	@Column(name = "dtl_addr", length = 200)
	private String detailAddress; // 상세_주소

	@Column(name = "zipcode", length = 6)
	private String zipcode; // 우편번호

	@Column(name = "upd_mngr_serlno")
	private Long updateManagerSerialNo; // 수정_관리자_일련번호

	@CreatedDate
	@Column(name = "upd_dtm", nullable = false)
	private LocalDateTime updateAt; // 수정_일시
}