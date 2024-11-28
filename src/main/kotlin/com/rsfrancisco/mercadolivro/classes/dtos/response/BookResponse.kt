package com.rsfrancisco.mercadolivro.classes.dtos.response

import com.rsfrancisco.mercadolivro.classes.enums.BookStatus

import java.math.BigDecimal

data class BookResponse(
    val id: Int? = null,
    val title: String,
    val price: BigDecimal,
    val status: BookStatus? = null,
    val customer: CustomerResponse? = null
)