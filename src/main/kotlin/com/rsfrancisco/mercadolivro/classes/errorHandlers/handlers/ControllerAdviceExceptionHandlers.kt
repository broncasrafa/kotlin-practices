package com.rsfrancisco.mercadolivro.classes.errorHandlers.handlers

import com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions.BaseException
import com.rsfrancisco.mercadolivro.classes.errorHandlers.responses.ErrorResponse
import jakarta.servlet.http.HttpServletRequest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class ControllerAdviceExceptionHandlers {

    @ExceptionHandler(BaseException::class)
    fun handleException(exception: BaseException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val errorMessage = exception.message
        val statusCode = exception.statusCode.value()
        val error = ErrorResponse(
            status = statusCode,
            message =  errorMessage,
            path = request.requestURI
        )


//        val error = ErrorResponse(
//            httpCode = HttpStatus.NOT_FOUND.value(),
//            message = errorMessage!!,
//            internalCode = "", //exception.errorCode,
//            errors = null)

        return ResponseEntity.status(statusCode).body<ErrorResponse>(error)
    }
}