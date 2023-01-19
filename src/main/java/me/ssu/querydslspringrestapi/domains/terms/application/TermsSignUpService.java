package me.ssu.querydslspringrestapi.domains.terms.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ssu.querydslspringrestapi.config.error.DataNotFoundException;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberMaster;
import me.ssu.querydslspringrestapi.domains.member.dto.MemberSignUp;
import me.ssu.querydslspringrestapi.domains.terms.domain.Terms;
import me.ssu.querydslspringrestapi.domains.terms.domain.TermsAgreementHistory;
import me.ssu.querydslspringrestapi.domains.terms.domain.TermsMemberAgreement;
import me.ssu.querydslspringrestapi.domains.terms.repository.TermsAgreementHistoryRepository;
import me.ssu.querydslspringrestapi.domains.terms.repository.TermsMemberAgreementRepository;
import me.ssu.querydslspringrestapi.domains.terms.repository.TermsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TermsSignUpService {

	private final TermsAgreementHistoryRepository termsAgreementHistoryRepository;
	private final TermsMemberAgreementRepository termsMemberAgreementRepository;
	private final TermsRepository termsRepository;

	@Transactional
	public void createNewTerms(MemberMaster newMember, MemberSignUp.Request request) {
		// 약관 조회

		// 약관 회원 동의
//		createTermsAgreementHistory(newMember, request, terms);

		// 약관 동의 이력
//		createTermsMemberAgreement(newMember, request, terms);
	}

	/**
	 * 약관_회원_동의
	 * @param newMember
	 * @param request
	 * @param terms
	 */
//	private void createTermsMemberAgreement(MemberMaster newMember, MemberSignUp.Request request, Terms terms) {
//		var processNewTermsMemberAgreement = TermsMemberAgreement.create(newMember, terms, request.getAgreementYn());
//		termsMemberAgreementRepository.save(processNewTermsMemberAgreement);
//	}

	/**
	 * 약관_동의_이력
	 * @param newMember
	 * @param request
	 * @param terms
	 */
//	private void createTermsAgreementHistory(MemberMaster newMember, MemberSignUp.Request request, Terms terms) {
//		var processNewTermsAgreementHistory = TermsAgreementHistory
//				.create(newMember, terms, request.getTermsAgreementYn());
//		termsAgreementHistoryRepository.save(processNewTermsAgreementHistory);
//	}
}