package me.youngwoo.limitedslot.auth.service.controller

import jakarta.validation.Valid
import me.youngwoo.limitedslot.auth.service.AuthService
import me.youngwoo.limitedslot.auth.service.controller.dto.AuthControllerSignupRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping(path = ["api/auth"])
class AuthController(private val authService: AuthService) {
    @PostMapping(path = ["/signup"], consumes = ["application/json"])
    fun signup(
        @Valid @RequestBody(required = true) body: AuthControllerSignupRequestDto,
    ) {
        authService.signup(id = body.id, password = body.password, name = body.name)
    }
}
