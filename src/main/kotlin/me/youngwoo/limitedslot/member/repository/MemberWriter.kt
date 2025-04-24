package me.youngwoo.limitedslot.member.repository

import me.youngwoo.limitedslot.member.domain.MemberDomain
import me.youngwoo.limitedslot.member.service.IMemberWriter
import org.springframework.stereotype.Component

@Component
class MemberWriter(private val memberRepository: MemberRepository) : IMemberWriter {
    override fun save(member: MemberDomain): MemberDomain {
        val memberEntity = MemberEntity.domainToEntity(member)
        val savedMemberEntity = memberRepository.save(memberEntity)
        return MemberEntity.entityToDomain(savedMemberEntity)
    }
}
