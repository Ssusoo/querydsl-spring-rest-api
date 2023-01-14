package me.ssu.querydslspringrestapi.domains.member.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ssu.querydslspringrestapi.config.constant.ApiResponseCode;
import me.ssu.querydslspringrestapi.config.error.BusinessException;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberMaster;
import me.ssu.querydslspringrestapi.domains.member.dto.SignUpMember;
import me.ssu.querydslspringrestapi.domains.member.repository.MemberMasterRepository;
import me.ssu.querydslspringrestapi.domains.terms.application.TermsSignUpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignUpMemberService {

	private final MemberMasterRepository memberMasterRepository;
	private final TermsSignUpService termsSignUpService;

	@Transactional
	public void processNewMember(SignUpMember.Request request) {
		// 회원 이력 입력
		var newMember = createNewMember(request);

		// 약관
		termsSignUpService.createNewTerms(newMember, request);
	}

	/**
	 * 회원 이력 저장
	 * @param request
	 * @return
	 */
	private MemberMaster createNewMember(SignUpMember.Request request) {
		// 비밀번호 입력 체크
		if (request.getMemberPassword().equals(request.getCheckMemberPassword())) {
			throw new BusinessException(ApiResponseCode.INVALID_INPUT_VALUE,
					"비밀번호가 일치하지 않습니다.");
		}

		// 회원가입 정보 저장
		var newMemberMaster = MemberMaster.create(request);
		memberMasterRepository.save(newMemberMaster);

		return newMemberMaster;
	}
}