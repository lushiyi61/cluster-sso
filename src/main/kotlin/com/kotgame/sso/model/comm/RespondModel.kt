package com.kotgame.sso.model.comm

data class RespondModel(
        val code: Int = 0,                              // 返回码
        val message: String = "success",                // 错误提示
        val data: Any? = null                           // 其它数据
)