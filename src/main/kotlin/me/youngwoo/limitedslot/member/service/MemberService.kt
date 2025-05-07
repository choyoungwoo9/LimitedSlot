package me.youngwoo.limitedslot.member.service

import me.youngwoo.limitedslot.member.domain.MemberDomain
import me.youngwoo.limitedslot.member.service.exception.IdDuplicateException
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberWriter: IMemberWriter,
    private val memberReader: IMemberReader,
) {
    fun createMember(
        id: String,
        password: String,
        name: String,
    ): MemberDomain {
        if (memberReader.isIdExist(id)) {
            throw IdDuplicateException("id: $id")
        }
        return memberWriter.save(MemberDomain(id = id, password = password, name = name))
    }
}
