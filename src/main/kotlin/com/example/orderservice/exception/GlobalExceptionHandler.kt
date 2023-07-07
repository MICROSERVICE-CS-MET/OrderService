package com.example.orderservice.exception
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class GlobalExceptionHandler(
    val exceptionUtil: ExceptionUtil
) {
    @ExceptionHandler
    fun handleGeneralException(ex: Exception, request: WebRequest): ResponseEntity<GeneralExceptionMessage> {
        val servletRequest = request as ServletWebRequest
        val errorMessage = GeneralExceptionMessage(
            ex.message, exceptionUtil.getFullUri(servletRequest.request), HttpStatus.INTERNAL_SERVER_ERROR.value()
        )
        return ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}