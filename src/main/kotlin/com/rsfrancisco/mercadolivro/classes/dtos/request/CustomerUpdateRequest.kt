package com.rsfrancisco.mercadolivro.classes.dtos.request

import jakarta.validation.constraints.*

class CustomerUpdateRequest (
    @field:NotEmpty
    @field:Min(value = 1, message = "ID must be greater than 0")
    var id: Int,

    @field:NotEmpty
    var name: String,

    @field:NotEmpty
    @field:Email
    var email: String
)