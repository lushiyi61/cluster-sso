package com.kotgame.sso

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class SsoApplication

fun main(args: Array<String>) {
	runApplication<SsoApplication>(*args)
}
