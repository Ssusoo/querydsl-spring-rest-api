package me.ssu.querydslspringrestapi.domains.member.repository;

import me.ssu.querydslspringrestapi.base.repository.BaseRepository;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberMaster;
import org.springframework.stereotype.Repository;

@Repository
public class MemberMasterRepository extends BaseRepository<MemberMaster, Long> {
}
