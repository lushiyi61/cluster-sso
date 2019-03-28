package com.kotgame.sso.table

object AccountTable : BaseTable("account") {
    val account = varchar("account", 64).primaryKey()    // 账号
    val password = varchar("password", 64)  // 密码
}