package com.kotgame.sso.server.sql

import com.kotgame.sso.exception.ResponseCode
import com.kotgame.sso.table.AccountTable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class AccountServer {
//    fun get(account: String): String? {
//        return transaction {
//            AccountTable.select {
//                AccountTable.account.eq(account)
//            }.map {
//                it[AccountTable.account]
//            }.firstOrNull()
//        }
//    }

    fun create(account: String, password: String): String {
        return try {
            transaction {
                AccountTable.insert {
                    it[AccountTable.account] = account
                    it[AccountTable.password] = password
                } get AccountTable.account
            } ?: error(ResponseCode.ACCOUNT_EXIST)
        } catch (e: Exception) {
            error(ResponseCode.ACCOUNT_EXIST)
        }
    }

    fun check(account: String, password: String): String {
        return transaction {
            AccountTable.select {
                AccountTable.account.eq(account) and
                        AccountTable.password.eq(password)
            }.map {
                if (it[AccountTable.deleted] != null) error(ResponseCode.ACCOUNT_FORBIDDEN)
                it[AccountTable.account]
            }.firstOrNull()
        } ?: error(ResponseCode.VERIFY_FAILURE)
    }
}