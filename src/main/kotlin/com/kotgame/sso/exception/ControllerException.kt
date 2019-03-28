package com.kotgame.sso.exception

import com.kotgame.sso.model.comm.RespondModel
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice
@RestController
class ControllerException {
    @ExceptionHandler(value = [Exception::class])
    fun defaultErrorHandler(e: Exception): RespondModel {
//        if (ApplicationConfig.dev) e.printStackTrace()
        return when (e) {
            is MethodArgumentNotValidException,
            is HttpMessageNotReadableException -> RespondModel(ResponseCode.PARAMS_INVALID.code, ResponseCode.PARAMS_INVALID.message, e.message)
            else -> try {
                val responseCode = ResponseCode.valueOf(e.message.toString())
                RespondModel(responseCode.code, responseCode.message, e.message)
            } catch (e: Exception) {
                RespondModel(ResponseCode.SYS_UNKNOWN_ERR.code, ResponseCode.SYS_UNKNOWN_ERR.message, e.message)
            }
        }
    }
}