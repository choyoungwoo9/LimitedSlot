package me.youngwoo.limitedslot.auth.service

import me.youngwoo.limitedslot.auth.service.type.AccessToken
import me.youngwoo.limitedslot.member.service.MemberService
import org.springframework.stereotype.Service

@Service
class AuthService(private val memberService: MemberService, private val jwtTokenHelper: JwtTokenHelper) {
    fun signup(
        id: String,
        password: String,
        name: String,
    ): String {
        val member = memberService.createMember(id, password, name)
        return createAccessToken(member.id)
    }

    private fun createAccessToken(id: String): String {
        val expiredTime = 7 * 24 * 60 * 60 * 1000 * 1L // 7일
        val accessTokenObj = AccessToken(id)
        val accessToken = jwtTokenHelper.createToken(accessTokenObj.objToMap(), expiredTime)
        return accessToken
    }
}
