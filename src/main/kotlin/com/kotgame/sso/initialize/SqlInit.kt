package com.kotgame.sso.initialize

import com.kotgame.sso.table.AccountTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SqlInit : CommandLineRunner {
    override fun run(vararg args: String) {
        val theTables = arrayOf(
                AccountTable
        )

        transaction {
            //  CREATE TABLE IF NOT EXISTS
            SchemaUtils.create(*theTables)
        }
    }
}