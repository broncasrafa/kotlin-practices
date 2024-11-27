package com.rsfrancisco.mercadolivro.classes.extensions

import com.rsfrancisco.mercadolivro.classes.dtos.response.*
import com.rsfrancisco.mercadolivro.classes.models.*

fun CustomerModel.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(id = this.id!!.toInt(), name = this.name, email = this.email, status = this.status)
}
fun List<CustomerModel>.toCustomerResponse(): List<CustomerResponse> {
    return this.map { it.toCustomerResponse() }
}

fun BookModel.toBookResponse(): BookResponse {
    return BookResponse(
        id = this.id!!.toInt(),
        title = this.title,
        price = this.price,
        status = this.status,
        customer = this.customer!!.toCustomerResponse()
    )
}
fun List<BookModel>.toBookResponse(): List<BookResponse> {
    return this.map { it.toBookResponse() }
}