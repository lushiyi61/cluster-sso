package com.kotgame.sso.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("app")
object ApplicationConfig {
    @Value("\${app.dev}")
    var dev: Boolean = false
}