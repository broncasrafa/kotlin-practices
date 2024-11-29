package com.rsfrancisco.mercadolivro.classes.dtos.response

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import java.time.LocalDateTime

data class PurchaseResponse (
    val id: Int,
    val price: BigDecimal,
    val nfe: String,
    @JsonAlias("purchase_date")
    val purchaseDate: LocalDateTime,
    val customer: CustomerResponse,
    val books: List<BookResponse>
)