package com.rsfrancisco.mercadolivro.classes.dtos.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.*

data class PurchaseCreateRequest(
    @field:NotNull
    @field:Positive
    @JsonAlias("customer_id")
    val customerId: Int,

    @field:NotNull
    @JsonAlias("book_ids")
    val bookIds: Set<Int>
)