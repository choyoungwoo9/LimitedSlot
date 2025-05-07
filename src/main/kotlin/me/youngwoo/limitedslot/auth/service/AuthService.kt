package me.youngwoo.limitedslot.auth.service

import me.youngwoo.limitedslot.member.service.MemberService
import org.springframework.stereotype.Service

@Service
class AuthService(private val memberService: MemberService) {
    fun signup(
        id: String,
        password: String,
        name: String,
    ): String  {
        val member = memberService.createMember(id, password, name)
        return "access token"
    }
}
