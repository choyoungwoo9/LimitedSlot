package me.youngwoo.limitedslot.auth.service

import me.youngwoo.limitedslot.auth.service.exception.IdDuplicateException
import me.youngwoo.limitedslot.auth.service.type.AccessToken
import me.youngwoo.limitedslot.member.domain.MemberDomain
import me.youngwoo.limitedslot.member.service.IMemberReader
import me.youngwoo.limitedslot.member.service.IMemberWriter
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val memberWriter: IMemberWriter,
    private val memberReader: IMemberReader,
    private val jwtTokenHelper: JwtTokenHelper,
) {
    fun signup(
        id: String,
        password: String,
        name: String,
    ): String {
        val member = createMember(id, password, name)
        return createAccessToken(member.id)
    }

    private fun createMember(
        id: String,
        password: String,
        name: String,
    ): MemberDomain {
        if (memberReader.isIdExist(id)) {
            throw IdDuplicateException("id: $id")
        }
        return memberWriter.save(MemberDomain(id = id, password = password, name = name))
    }

    private fun createAccessToken(id: String): String {
        val expiredTime = 7 * 24 * 60 * 60 * 1000 * 1L // 7일
        val accessTokenObj = AccessToken(id)
        val accessToken = jwtTokenHelper.createToken(accessTokenObj.objToMap(), expiredTime)
        return accessToken
    }
}
