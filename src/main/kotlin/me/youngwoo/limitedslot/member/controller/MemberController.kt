package me.youngwoo.limitedslot.member.controller

import jakarta.validation.Valid
import me.youngwoo.limitedslot.member.controller.dto.MemberControllerSignupRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping(path = ["api/member"])
class MemberController {
    @PostMapping(path = ["/signup"], consumes = ["application/json"])
    fun signup(
        @Valid @RequestBody(required = true) body: MemberControllerSignupRequestDto,
    ) {
    }
}
