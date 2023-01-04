package me.ssu.querydslspringrestapi.domains.member.repository;

import me.ssu.querydslspringrestapi.base.repository.BaseRepository;
import me.ssu.querydslspringrestapi.domains.member.domain.MemberUpdateHistory;
import org.springframework.stereotype.Repository;

@Repository
public class MemberUpdateRepository extends BaseRepository<MemberUpdateHistory, Long> {
}
