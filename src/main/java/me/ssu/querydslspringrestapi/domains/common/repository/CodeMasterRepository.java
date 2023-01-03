package me.ssu.querydslspringrestapi.domains.common.repository;

import me.ssu.querydslspringrestapi.base.repository.BaseRepository;
import me.ssu.querydslspringrestapi.domains.common.domain.CodeMaster;
import me.ssu.querydslspringrestapi.domains.common.domain.QCodeDetail;
import me.ssu.querydslspringrestapi.domains.common.domain.QCodeMaster;
import me.ssu.querydslspringrestapi.domains.common.dto.CommonCodes;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.ssu.querydslspringrestapi.config.constant.CommonConstant.Yn;

@Repository
public class CodeMasterRepository extends BaseRepository<CodeMaster, String> {
	private static final QCodeMaster codeMaster = QCodeMaster.codeMaster;
	private static final QCodeDetail codeDetail = QCodeDetail.codeDetail;

	public List<CommonCodes.CommonCode> findAll() {
		return select(
				CommonCodes.CommonCode.class,
				codeMaster.commonMasterCode,
				codeDetail.commonCode,
				codeDetail.commonCodeName,
				codeDetail.useYn)
				.from(codeMaster)
				.innerJoin(codeDetail)
				.on(codeMaster.commonMasterCode.eq(codeDetail.codeMaster.commonMasterCode))
				.where(codeMaster.useYn.eq(Yn.Y)
						.and(codeDetail.useYn.eq(Yn.Y)))
				.orderBy(codeMaster.commonMasterCode.asc(),
						codeMaster.codeSortNo.asc(),
						codeDetail.codeSortNo.asc())
				.fetch();
	}
}