package com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions

import org.springframework.http.HttpStatus

abstract class BaseException (
    message: String,
    val statusCode: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
) : RuntimeException(message)