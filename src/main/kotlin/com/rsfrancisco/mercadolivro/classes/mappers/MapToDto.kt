package com.rsfrancisco.mercadolivro.classes.mappers

import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.dtos.response.CustomerResponse
import com.rsfrancisco.mercadolivro.classes.entities.Book
import com.rsfrancisco.mercadolivro.classes.entities.Customer




fun Customer.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}
fun List<Customer>.toCustomerResponse(): List<CustomerResponse>{
    return this.map { it.toCustomerResponse() }
}

fun Book.toBookResponse(): BookResponse {
    return BookResponse(
        id = this.id!!.toInt(),
        title = this.title,
        price = this.price,
        status = this.status,
        customer = this.customer!!.toCustomerResponse()
    )
}