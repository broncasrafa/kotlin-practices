package com.rsfrancisco.mercadolivro.classes.dtos.response

import com.rsfrancisco.mercadolivro.classes.entities.Customer
import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import java.math.BigDecimal

data class BookResponse(
    val id: Int,
    val title: String,
    val price: BigDecimal,
    val status: BookStatus?,
    val customer: Customer?
)