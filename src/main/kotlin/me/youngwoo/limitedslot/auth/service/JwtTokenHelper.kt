package me.youngwoo.limitedslot.auth.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtTokenHelper(
    @Value("\${jwt.secret}") key: String,
) {
    private val key = Keys.hmacShaKeyFor(key.toByteArray())

    fun createToken(
        claims: Map<String, Any>,
        expirationMillis: Long,
    ): String {
        return Jwts.builder()
            .claims(
                claims,
            )
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + expirationMillis))
            .signWith(key)
            .compact()
    }

    fun parseToken(token: String): Map<String, Any> {
        val jws =
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
        val claims = jws.body
        return claims
    }
}
