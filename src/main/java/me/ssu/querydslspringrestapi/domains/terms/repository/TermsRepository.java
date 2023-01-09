package me.ssu.querydslspringrestapi.domains.terms.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import me.ssu.querydslspringrestapi.base.repository.BaseRepository;
import me.ssu.querydslspringrestapi.domains.terms.domain.QTerms;
import me.ssu.querydslspringrestapi.domains.terms.domain.Terms;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TermsRepository extends BaseRepository<Terms, Long> {

	private final QTerms terms = QTerms.terms;
	
	/**
	 * 약관_조회
	 * @param termsCode
	 * @param termsTurnOrderNo
	 * @return
	 */
	public Optional<Terms> findByTermsCodeAndTermsTurnOrderNo(String termsCode, Integer termsTurnOrderNo) {
		return Optional.ofNullable(selectFrom(terms)
				.where(eqTermsCode(termsCode).and(eqTermsTurnOrderNo(termsTurnOrderNo)))
				.fetchFirst());
	}

	/**
	 * 회차_일련번호_비교
	 * @param termsTurnOrderNo
	 * @return
	 */
	private BooleanBuilder eqTermsTurnOrderNo(Integer termsTurnOrderNo) {
		if (termsTurnOrderNo == null) {
			new BooleanBuilder();
		}
		return new BooleanBuilder(terms.termsId.termsTurnOrderNo.eq(termsTurnOrderNo));
	}

	/**
	 * 약관_코드_비교
	 * @param termsCode
	 * @return
	 */
	private BooleanBuilder eqTermsCode(String termsCode) {
		if (termsCode.isEmpty()) {
			return new BooleanBuilder();
		}
		return new BooleanBuilder(terms.termsId.termsCode.eq(termsCode));
	}
}