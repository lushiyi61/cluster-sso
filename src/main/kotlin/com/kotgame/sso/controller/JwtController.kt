package com.kotgame.sso.controller

import com.kotgame.sso.model.comm.RespondModel
import com.kotgame.sso.server.sql.AccountServer
import com.kotgame.sso.server.sso.JwtServer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/jwt")
class JwtController {
    private val LOGGER = LoggerFactory.getLogger(JwtController::class.java)

    @Autowired
    lateinit var accountServer: AccountServer

    @Autowired
    lateinit var jwtServer: JwtServer

    @GetMapping("/login")
    fun login(@RequestParam account: String, @RequestParam password: String): RespondModel {
        accountServer.check(account, password)
        val token = jwtServer.create(account)
        return RespondModel(data = token)
    }

    @GetMapping("/check")
    fun check(@RequestParam token: String): RespondModel {
        val account = jwtServer.verify(token)
        return RespondModel(data = account)
    }

    @GetMapping("/update")
    fun update(@RequestParam token: String): RespondModel {
        val account = jwtServer.verify(token)
        return RespondModel(data = jwtServer.create(account))
    }

    @GetMapping("/register")
    fun register(@RequestParam account: String, @RequestParam password: String): RespondModel {
        accountServer.create(account, password)
        return RespondModel(data = jwtServer.create(account))
    }

    @GetMapping("/reset-account")
    fun resetAccount(): RespondModel {
        return RespondModel()
    }

    @GetMapping("/modify-password")
    fun modifyPassword(): RespondModel {
        return RespondModel()
    }

    @GetMapping("/reset-password")
    fun resetPassword(): RespondModel {
        return RespondModel()
    }

    @GetMapping("/logout")
    fun logout(): RespondModel {
        return RespondModel()
    }
}