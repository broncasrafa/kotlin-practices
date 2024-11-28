package com.rsfrancisco.mercadolivro.classes.dtos.request

import jakarta.validation.constraints.*

data class CustomerCreateRequest(

    @field:NotEmpty
    var name: String,

    @field:NotEmpty
    @field:Email
    var email: String
)