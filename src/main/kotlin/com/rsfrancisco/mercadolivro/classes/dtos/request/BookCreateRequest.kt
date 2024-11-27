package com.rsfrancisco.mercadolivro.classes.dtos.request

import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import java.math.BigDecimal

class BookCreateRequest (
    val title: String,
    val price: BigDecimal,
    val status: BookStatus?,
    val customerId: Int
)