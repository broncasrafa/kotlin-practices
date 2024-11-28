package com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions

import org.springframework.http.HttpStatus

class CustomerNotFoundException (id: Int)
    : BaseException("Customer with ID: '${id}' was not found", HttpStatus.NOT_FOUND)