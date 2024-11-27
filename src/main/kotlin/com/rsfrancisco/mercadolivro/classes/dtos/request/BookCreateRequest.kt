package com.rsfrancisco.mercadolivro.classes.dtos.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class BookCreateRequest (
    var title: String,

    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
)