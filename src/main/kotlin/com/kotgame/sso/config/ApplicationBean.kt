package com.kotgame.sso.config

import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class ApplicationBean {
//    @Bean
//    fun redisTemplate(redisConnectionFactory: LettuceConnectionFactory): RedisTemplate<String, Any> {
//        val redisTemplate = RedisTemplate<String, Any>()
//        redisTemplate.setConnectionFactory(redisConnectionFactory)
//        return redisTemplate
//    }

    @Bean
    fun transactionManager(dataSource: HikariDataSource): SpringTransactionManager {
        return SpringTransactionManager(dataSource as DataSource)
    }

}