package com.kotgame.sso.table

import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

abstract class BaseTable(table: String) : Table(table) {
    val deleted = datetime("deleted_at").nullable()
    val updated = datetime("updated_at").default(DateTime.now())
    val created = datetime("created_at").default(DateTime.now())
    val remark = text("remark").default("")
}