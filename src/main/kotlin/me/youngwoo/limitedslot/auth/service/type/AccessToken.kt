package me.youngwoo.limitedslot.auth.service.type

import me.youngwoo.limitedslot.auth.service.exception.InvalidJwtFormatException

data class AccessToken(
    val id: String,
) {
    fun objToMap(): Map<String, Any> {
        return mapOf("id" to id)
    }

    companion object {
        fun mapToObj(map: Map<String, Any>): AccessToken {
            val id =
                map["id"] as? String
                    ?: throw InvalidJwtFormatException()
            return AccessToken(id)
        }
    }
}
