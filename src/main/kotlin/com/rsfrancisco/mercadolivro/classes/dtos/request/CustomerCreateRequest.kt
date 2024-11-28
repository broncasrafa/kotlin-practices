package com.rsfrancisco.mercadolivro.classes.dtos.request

import com.rsfrancisco.mercadolivro.classes.validations.EmailAvailable
import jakarta.validation.constraints.*

data class CustomerCreateRequest(

    @field:NotEmpty
    var name: String,

    @field:NotEmpty
    @field:Email
    @EmailAvailable
    var email: String
)