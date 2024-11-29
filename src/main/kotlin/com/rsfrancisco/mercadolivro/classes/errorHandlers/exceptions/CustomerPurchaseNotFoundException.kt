package com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions

import org.springframework.http.HttpStatus

class CustomerPurchaseNotFoundException (id: Int)
    : BaseException("Customer purchases with ID: '${id}' was not found", HttpStatus.NOT_FOUND)