package com.rsfrancisco.mercadolivro.classes.dtos.request

import jakarta.validation.constraints.*
import java.math.BigDecimal

data class BookUpdateRequest (
    @field:NotEmpty
    @field:Min(value = 1, message = "Id must be greater than 0")
    var id: Int,

    @field:NotEmpty
    val title: String?,

    @field:NotEmpty
    @field:Min(value = 1, message = "Price must be greater than 0")
    val price: BigDecimal?
)