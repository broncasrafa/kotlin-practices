package com.rsfrancisco.mercadolivro.classes.dtos.request

import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import java.math.BigDecimal

data class BookUpdateRequest (
    var id: Int,
    val title: String,
    val price: BigDecimal
)