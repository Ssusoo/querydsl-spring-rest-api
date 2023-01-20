package me.ssu.querydslspringrestapi.domains.member.domain;

import lombok.*;
import me.ssu.querydslspringrestapi.base.domain.BaseEntity;
import me.ssu.querydslspringrestapi.config.constant.CommonConstant;
import me.ssu.querydslspringrestapi.domains.member.dto.MemberSignUp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

import static me.ssu.querydslspringrestapi.config.constant.CommonConstant.Yn.N;
import static me.ssu.querydslspringrestapi.config.constant.CommonConstant.Yn.Y;

@Entity
@Table(name = "ssu_mem_mst")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class MemberMaster extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_serlno")
	private Long memberSerialNo; // 회원_일련번호

	@Column(name = "mem_email", length = 200, nullable = false, updatable = false)
	private String memberEmail; // 회원_이메일

	@Column(name = "mem_nm", length = 100, nullable = false, updatable = false)
	private String memberName; // 회원_이름

	@Column(name = "mem_pwd", length = 150, nullable = false)
	private String memberPassword; // 회원_비밀번호

	@Column(name = "birthymd")
	private LocalDateTime birthDate; // 생년월일

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

	@Column(name = "use_yn", length = 1, nullable = false)
	private String useYn; // 사용 여부

	@CreatedDate
	@Column(name = "reg_dtm", nullable = false, updatable = false)
	private LocalDateTime registerAt; // 등록_일시

	@LastModifiedDate
	@Column(name = "upd_dtm", nullable = false)
	private LocalDateTime updateAt; // 수정_일시

	@Column(name = "dmt_yn", length = 1, nullable = false)
	private String dormantYn; // 휴면_여부

	@Column(name = "dmt_dtm")
	private LocalDateTime dormantAt; // 휴먼_일시

	@Column(name = "wd_yn", length = 1, nullable = false)
	private String withdrawalYn; // 탈퇴_여부

	@Column(name = "wd_dtm")
	private LocalDateTime withdrawalAt; // 탈퇴_일시

	/**
	 * 회원 이력 저장
	 * @param request
	 * @return
	 */
	public static MemberMaster create(MemberSignUp.Request request) {
		return MemberMaster.builder()
				.memberEmail(request.getMemberEmail())
				.memberName(request.getMemberName())
				.memberPassword(request.getMemberPassword())
				.birthDate(request.getBirthDate())
				.memberGenderFlag(request.getMemberGenderFlag())
				.memberMobileTelephoneNumber(request.getMemberMobileTelephoneNumber())
				.basicAddress(request.getBasicAddress())
				.detailAddress(request.getDetailAddress())
				.zipcode(request.getZipcode())
				.build();
	}
}