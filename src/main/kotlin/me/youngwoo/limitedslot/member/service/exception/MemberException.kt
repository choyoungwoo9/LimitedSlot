package me.youngwoo.limitedslot.member.service.exception

import me.youngwoo.limitedslot.common.exception.AppException

sealed class MemberException(
    message: String,
    cause: Throwable? = null,
) : AppException(message, cause)
