package com.rsfrancisco.mercadolivro.classes.dtos.response

import com.rsfrancisco.mercadolivro.classes.enums.CustomerStatus

data class CustomerResponse(
    var id: Int,
    var name: String,
    var email: String,
    val status: CustomerStatus
)