package com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions

import org.springframework.http.HttpStatus

class BookNotFoundException(id: Int)
    : BaseException("Book with ID: '${id}' was not found", HttpStatus.NOT_FOUND)