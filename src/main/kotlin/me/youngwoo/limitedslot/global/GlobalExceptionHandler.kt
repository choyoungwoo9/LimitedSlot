package me.youngwoo.limitedslot.global

import me.youngwoo.limitedslot.member.service.exception.IdDuplicateException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>> {
        val errorMap =
            ex.bindingResult.fieldErrors.associate { fieldError ->
                fieldError.field to (fieldError.defaultMessage)
            }
        val response =
            mapOf(
                "validationErrors" to errorMap,
            )
        return ResponseEntity.badRequest().body(response)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleJsonParseException(ex: HttpMessageNotReadableException): ResponseEntity<Map<String, Any>> {
        val response =
            mapOf(
                "message" to "요청 형식 오류",
            )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response)
    }

    @ExceptionHandler(IdDuplicateException::class)
    fun handleIdDuplicateException(): ResponseEntity<String> {
        val response = "ID 중복"
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response)
    }
}
