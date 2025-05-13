package me.youngwoo.limitedslot.auth.service.exception

import me.youngwoo.limitedslot.common.exception.AppException

sealed class AuthException(
    message: String,
    cause: Throwable? = null,
) : AppException(message, cause)

class InvalidJwtFormatException(
    message: String = "Jwt 토큰의 claim 형식이 유효하지 않습니다.",
    cause: Throwable? = null,
) : AuthException(message, cause)

class IdDuplicateException(
    message: String = "ID가 중복되었습니다.",
    cause: Throwable? = null,
) : AuthException(message, cause)
