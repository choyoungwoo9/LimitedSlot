package me.youngwoo.limitedslot.api.auth.signup

import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.BehaviorSpec
import me.youngwoo.limitedslot.auth.controller.dto.AuthControllerSignupRequestDto
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SignupE2ETest(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper,
) : BehaviorSpec({
    context("회원가입 E2E 테스트") {
        given("첫 가입이며 유효한 데이터") {
            `when`("회원가입 요청을 보내면") {
                val request = objectMapper.writeValueAsString(
                    AuthControllerSignupRequestDto(
                        id = "id",
                        password = "password",
                        name = "조영우"
                    )
                )
                then("성공하고 201을 반환") {
                    mockMvc.post("/api/auth/signup") {
                        contentType = MediaType.APPLICATION_JSON
                        content = request
                    }.andExpect {
                        status { isNoContent() }
                    }
                }
            }
        }

        given("이미가입되어 있으면") {
            `when`("회원가입 요청을 보내면") {
                val request = objectMapper.writeValueAsString(
                    AuthControllerSignupRequestDto(
                        id = "id",
                        password = "password",
                        name = "조영우"
                    )
                )
                then("실패하고 401을 반환") {
                    mockMvc.post("/api/auth/signup") {
                        contentType = MediaType.APPLICATION_JSON
                        content = request
                    }.andExpect {
                        status { isConflict() }
                    }
                }
            }
        }
    }
})
