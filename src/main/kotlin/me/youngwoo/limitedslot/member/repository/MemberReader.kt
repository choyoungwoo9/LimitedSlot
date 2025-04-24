package me.youngwoo.limitedslot.member.repository

import me.youngwoo.limitedslot.member.service.IMemberReader
import org.springframework.stereotype.Component

@Component
class MemberReader(private val memberRepository: MemberRepository) : IMemberReader {
    override fun isIdExist(id: String): Boolean = memberRepository.existsById(id)
}
