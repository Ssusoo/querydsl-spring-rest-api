package me.ssu.querydslspringrestapi.domains.member.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberMaster;
import me.ssu.querydslspringrestapi.domains.member.dto.SignUpMember;
import me.ssu.querydslspringrestapi.domains.terms.repository.TermsAgreementHistoryRepository;
import me.ssu.querydslspringrestapi.domains.terms.repository.TermsMemberAgreementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignUpTermsService {

	private final TermsAgreementHistoryRepository termsAgreementHistoryRepository;
	private final TermsMemberAgreementRepository termsMemberAgreementRepository;

	public void create(MemberMaster newMember, SignUpMember.Request request) {

		

	}
}
