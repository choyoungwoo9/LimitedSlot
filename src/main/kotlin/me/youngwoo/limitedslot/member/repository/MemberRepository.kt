package me.youngwoo.limitedslot.member.repository

import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<MemberEntity, String>
