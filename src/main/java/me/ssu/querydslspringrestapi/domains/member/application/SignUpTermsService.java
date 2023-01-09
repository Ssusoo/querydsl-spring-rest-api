package me.ssu.querydslspringrestapi.domains.member.application;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ssu.querydslspringrestapi.config.error.DataNotFoundException;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberMaster;
import me.ssu.querydslspringrestapi.domains.member.dto.SignUpMember;
import me.ssu.querydslspringrestapi.domains.terms.domain.Terms;
import me.ssu.querydslspringrestapi.domains.terms.domain.TermsAgreementHistory;
import me.ssu.querydslspringrestapi.domains.terms.domain.TermsMemberAgreement;
import me.ssu.querydslspringrestapi.domains.terms.repository.TermsAgreementHistoryRepository;
import me.ssu.querydslspringrestapi.domains.terms.repository.TermsMemberAgreementRepository;
import me.ssu.querydslspringrestapi.domains.terms.repository.TermsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignUpTermsService {

	private final TermsAgreementHistoryRepository termsAgreementHistoryRepository;
	private final TermsMemberAgreementRepository termsMemberAgreementRepository;
	private final TermsRepository termsRepository;

	public void create(MemberMaster newMember, SignUpMember.Request request) {
		// 약관 조회
		var terms = termsRepository.findByTermsCodeAndTermsTurnOrderNo(request.getTermsCode(),
				request.getTermsTurnOrderNo()).orElseThrow(DataNotFoundException::new);

		// 약관 회원 동의
		createTermsAgreementHistory(newMember, request, terms);

		// 약관 동의 이력
		createTermsMemberAgreement(newMember, request, terms);
	}

	/**
	 * 약관_회원_동의
	 * @param newMember
	 * @param request
	 * @param terms
	 */
	private void createTermsMemberAgreement(MemberMaster newMember, SignUpMember.Request request, Terms terms) {
		var processNewTermsMemberAgreement = TermsMemberAgreement.create(newMember, terms, request.getAgreementYn());
		termsMemberAgreementRepository.save(processNewTermsMemberAgreement);
	}

	/**
	 * 약관_동의_이력
	 * @param newMember
	 * @param request
	 * @param terms
	 */
	private void createTermsAgreementHistory(MemberMaster newMember, SignUpMember.Request request, Terms terms) {
		var processNewTermsAgreementHistory = TermsAgreementHistory
				.create(newMember, terms, request.getTermsAgreementYn());
		termsAgreementHistoryRepository.save(processNewTermsAgreementHistory);
	}
}