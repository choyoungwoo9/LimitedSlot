package me.youngwoo.limitedslot.auth.controller

import jakarta.validation.Valid
import me.youngwoo.limitedslot.auth.controller.dto.AuthControllerSignupRequestDto
import me.youngwoo.limitedslot.auth.service.AuthService
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
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
    ): ResponseEntity<Void> {
        val accessToken = authService.signup(id = body.id, password = body.password, name = body.name)

        val cookie =
            ResponseCookie.from("access_token", accessToken)
                .httpOnly(true)
                .path("/")
                .sameSite("Strict")
                .build()

        return ResponseEntity
            .noContent()
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .build()
    }
}
