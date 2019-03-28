package com.kotgame.sso.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("jwt")
object JwtConfig {

    @Value("\${jwt.timeout}")
    var timeout: Long = 3600L

    @Value("\${jwt.key}")
    lateinit var key: String
}