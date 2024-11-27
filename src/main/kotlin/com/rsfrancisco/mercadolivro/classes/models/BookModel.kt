package com.rsfrancisco.mercadolivro.classes.models

import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import java.math.BigDecimal

data class BookModel(
    var id: Int? = null,
    val title: String,
    val price: BigDecimal,
    val status: BookStatus?,
    val customerId: Int
)