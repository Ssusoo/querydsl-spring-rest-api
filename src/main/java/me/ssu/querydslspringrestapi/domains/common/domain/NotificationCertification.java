package me.ssu.querydslspringrestapi.domains.common.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Entity
@Table(name = "ssu_noti_cert")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationCertification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "noti_cert_serlno", nullable = false, updatable = false)
	private Long notificationCertificationSerialNo; // 알림_인증_일련번호

	@Column(name = "mem_serlno", nullable = false)
	private Long memberSerialNo; // 회원_일련번호

	@Column(name = "mem_nm", length = 100)
	private String memberName; // 회원_이름

	@Column(name = "mem_email", length = 200)
	private String memberEmail; // 회원_이메일(회원 아이디)

	@Column(name = "email", length = 200)
	private String email; // 이메일(보내는 이메일 용도)

	@Column(name = "mobile_telno", length = 20)
	private String mobileTelephoneNumber; // 모바일_전화번호

	@Column(name = "cert_val", length = 256)
	private String certificationValue; // 인증_값

	@Column(name = "noti_title", length = 200)
	private String notificationTitle; // 알림_제목

	@Column(name = "noti_cont")
	private String notificationContents; // 알림_내용

	@Column(name = "noti_send_tagt_div_comm_cd", length = 8, nullable = false)
	private String notificationSendTargetDivisionCommonCode; // 알림_발신_대상_구분_공통_코드

	@Column(name = "noti_recp_tagt_div_comm_cd", length = 8, nullable = false)
	private String notificationReceptionTargetDivisionCommonCode; // 알림_수신_대상_구분_공통_코드

	@Column(name = "noti_sed_div_comm_cd", length = 8)
	private String notificationSendDivisionCommonCode; // 알림_발송_구분_공통_코드

	@Column(name = "noti_tmplt_kind_comm_cd", length = 8, nullable = false)
	private String notificationTemplateKindCommonCode; // 알림_템플릿_종류_공통_코드

	@Column(name = "noti_lcasf_comm_cd", length = 8, nullable = false)
	private String notificationLargeClassificationCommonCode; // 알림_대분류_공통_코드

	@Column(name = "noti_smclasf_comm_cd", length = 8, nullable = false)
	private String notificationSmallClassificationCommonCode; // 알림_소분류_공통_코드

	@Column(name = "noti_kind_comm_cd", length = 8, nullable = false)
	private String notificationKindCommonCode; // 알림_종류_공통_코드

	@Column(name = "noti_stat_div_comm_cd", length = 8, nullable = false)
	private String notificationStatusDivisionCommonCode; // 알림_상태_구분_공통_코드

	@Column(name = "noti_resv_div_comm_cd", length = 8, nullable = false)
	private String notificationReservationDivisionCommonCode; // 알림_예약_구분_공통_코드

	@Column(name = "send_yn", length = 1, nullable = false)
	private String sendYn; // 발송_여부

	@CreatedDate
	@Column(name = "reg_dtm", nullable = false, updatable = false)
	private LocalDateTime registerAt; // 등록_일시
}