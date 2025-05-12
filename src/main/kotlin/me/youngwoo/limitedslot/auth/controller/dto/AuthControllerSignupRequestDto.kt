package me.youngwoo.limitedslot.auth.controller.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class AuthControllerSignupRequestDto(
    @field:NotBlank(message = "아이디는 필수 입력값입니다.")
    @field:Pattern(
        regexp = "^[a-z]{1,10}$",
        message = "아이디는 소문자 알파벳만 사용 가능하며, 최대 10자까지 입력할 수 있습니다.",
    )
    val id: String,
    @field:NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @field:Pattern(
        regexp = "^[a-z]{1,10}$",
        message = "비밀번호는 소문자 알파벳만 사용 가능하며, 최대 10자까지 입력할 수 있습니다.",
    )
    val password: String,
    @field:NotBlank(message = "이름은 필수 입력값입니다.")
    @field:Pattern(
        regexp = "^[가-힣]{1,4}$",
        message = "이름은 한글로만 입력해야 하며, 1자 이상 4자 이하로 입력해주세요.",
    )
    val name: String,
)
