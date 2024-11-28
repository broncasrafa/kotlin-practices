package com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions

import org.springframework.http.HttpStatus

class BookChangeStatusErrorException(message: String)
    : BaseException(message, HttpStatus.BAD_REQUEST)