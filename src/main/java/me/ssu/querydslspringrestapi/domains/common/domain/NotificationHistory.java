package me.ssu.querydslspringrestapi.domains.common.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Slf4j
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class NotificationHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "noti_hist_serlno", nullable = false, updatable = false)
	private Long notificationHistorySerialNo; // 알림_이력_일련번호

	@Column(name = "mem_email", length = 200, nullable = false)
	private String memberEmail; // 회원_이메일

	@Column(name = "noti_stat_cd", length = 4, nullable = false)
	private String notificationStatusCode; // 알림_상태_코드

	@Column(name = "sucs_dtm")
	private LocalDateTime successAt; // 성공_일시

	@Column(name = "fail_dtm")
	private LocalDateTime failureAt; // 실패_일시
}