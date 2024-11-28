package com.rsfrancisco.mercadolivro.classes.dtos.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.*
import java.math.BigDecimal

data class BookCreateRequest (

    @field:NotEmpty
    var title: String,

    @field:NotEmpty
    @field:Min(value = 1, message = "Price must be greater than 0")
    var price: BigDecimal,

    @field:NotEmpty
    @field:Min(value = 1, message = "Customer ID must be greater than 0")
    @JsonAlias("customer_id")
    var customerId: Int
)