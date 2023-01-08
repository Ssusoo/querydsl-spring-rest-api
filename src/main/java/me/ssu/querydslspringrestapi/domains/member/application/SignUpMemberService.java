package me.ssu.querydslspringrestapi.domains.member.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberMaster;
import me.ssu.querydslspringrestapi.domains.member.dto.SignUpMember;
import me.ssu.querydslspringrestapi.domains.member.repository.MemberMasterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignUpMemberService {

	private final MemberMasterRepository memberMasterRepository;

	@Transactional
	public void processNewMember(SignUpMember.Request request) {
		// 회원 이력 입력
		var newMember = createNewMember(request);

		// 약관 동의 이력
	}

	/**
	 * 회원 이력 저장
	 * @param request
	 * @return
	 */
	private MemberMaster createNewMember(SignUpMember.Request request) {
		var newMemberMaster = MemberMaster.create(request);
		// 회원 이력 저장
		memberMasterRepository.save(newMemberMaster);

		return newMemberMaster;
	}
}