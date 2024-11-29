package com.rsfrancisco.mercadolivro.classes.mappers

import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.dtos.response.CustomerResponse
import com.rsfrancisco.mercadolivro.classes.dtos.response.PurchaseResponse
import com.rsfrancisco.mercadolivro.classes.entities.Book
import com.rsfrancisco.mercadolivro.classes.entities.Customer
import com.rsfrancisco.mercadolivro.classes.entities.Purchase


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

fun Purchase.toPurchaseResponse(): PurchaseResponse {
    return PurchaseResponse (
        id = this.id!!.toInt(),
        price = this.price,
        nfe = this.nfe!!,
        purchaseDate = this.createdAt,
        customer = this.customer.toCustomerResponse(),
        books = this.books.toList().map { it.toBookResponse() }
    )
}