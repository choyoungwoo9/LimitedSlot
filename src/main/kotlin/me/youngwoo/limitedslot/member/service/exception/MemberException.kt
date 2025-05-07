package me.youngwoo.limitedslot.member.service.exception

import me.youngwoo.limitedslot.common.exception.AppException

sealed class MemberException(
    message: String,
    cause: Throwable? = null,
) : AppException(message, cause)

class IdDuplicateException(
    message: String = "ID가 중복되었습니다.",
    cause: Throwable? = null,
) : MemberException(message, cause)
