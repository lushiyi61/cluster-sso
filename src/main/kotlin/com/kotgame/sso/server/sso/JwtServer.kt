package com.kotgame.sso.server.sso

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.kotgame.sso.config.JwtConfig
import com.kotgame.sso.exception.ResponseCode
import org.springframework.stereotype.Service
import java.util.*


@Service
class JwtServer {

    @Throws(Exception::class)
    fun create(account: String, appId: String = ""): String {
        return JWT.create()
//                .withIssuer(appId)
                .withClaim("account", account)
                .withExpiresAt(Date(System.currentTimeMillis() + JwtConfig.timeout))
                .sign(getAlgorithm())

    }

    fun verify(token: String): String {
        return try {
            val jwt = JWT.require(getAlgorithm()).build().verify(token)
            jwt.getClaim("account").asString()
        } catch (e: Exception) {
            e.printStackTrace()
            error(ResponseCode.VERIFY_FAILURE)
        }
    }

    private fun getAlgorithm(): Algorithm {
        return Algorithm.HMAC256(JwtConfig.key)
    }
}