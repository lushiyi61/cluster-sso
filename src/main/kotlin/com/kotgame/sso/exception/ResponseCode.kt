package com.kotgame.sso.exception

enum class ResponseCode(val code: Int, val message: String) {
    OK(0, "请求成功"),
    NOT_FOUND(1000, "不存在"),
    CREATE_FAILURE(1001, "创建失败"),
    VERIFY_FAILURE(1002, "创建失败"),
    ACCOUNT_FORBIDDEN(1003, "账号被禁用"),
    ACCOUNT_EXIST(1004, "账号已存在"),
    PARAMS_INVALID(1005, "参数异常"),

    SYS_UNKNOWN_ERR(9999, "未知错误")
}