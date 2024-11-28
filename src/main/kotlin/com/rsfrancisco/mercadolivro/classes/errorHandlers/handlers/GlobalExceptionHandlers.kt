package com.rsfrancisco.mercadolivro.classes.errorHandlers.handlers

import com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions.BaseException
import com.rsfrancisco.mercadolivro.classes.errorHandlers.responses.ErrorResponse
import com.rsfrancisco.mercadolivro.classes.errorHandlers.responses.FieldErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionHandlers {

    @ExceptionHandler(BaseException::class)
    fun handleException(exception: BaseException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val errorMessage = exception.message
        val statusCode = exception.statusCode.value()
        val error = ErrorResponse(
            status = statusCode,
            message =  errorMessage,
            path = request.requestURI
        )
        return ResponseEntity.status(statusCode).body<ErrorResponse>(error)
    }


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(exception: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val statusCode = HttpStatus.BAD_REQUEST.value()
        var errors = exception.bindingResult.fieldErrors.map {
            FieldErrorResponse(message = it.defaultMessage ?: "Invalid value", field =  it.field)
        }
        val errorResponse = ErrorResponse(
            status = statusCode,
            message = "One or more validation errors occurred",
            errors = errors
        )
        return ResponseEntity.status(statusCode).body<ErrorResponse>(errorResponse)
    }
}