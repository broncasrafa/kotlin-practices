package com.rsfrancisco.mercadolivro.classes.mappers

import com.rsfrancisco.mercadolivro.classes.dtos.request.BookCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.BookUpdateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.dtos.response.CustomerResponse
import com.rsfrancisco.mercadolivro.classes.entities.Book
import com.rsfrancisco.mercadolivro.classes.entities.Customer
import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import com.rsfrancisco.mercadolivro.classes.enums.CustomerStatus


fun CustomerCreateRequest.toCustomerEntity(): Customer {
    return Customer(
        id = 0,
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO
    )
}
fun CustomerResponse.toCustomerEntity(): Customer {
    return Customer(
        id = this.id,
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO
    )
}

fun BookCreateRequest.toBookEntity(customer: Customer): Book {
    return Book(
        title = this.title,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}
fun BookUpdateRequest.toBookEntity(): Book {
    return Book(
        id = this.id,
        title = this.title!!,
        price = this.price!!,
        status = BookStatus.ATIVO,
        customer = null
    )
}
fun BookResponse.toBookEntity(): Book {
    return Book(
        id = this.id,
        title = this.title!!,
        price = this.price!!,
        status = BookStatus.ATIVO,
        customer = null
    )
}
fun List<BookResponse>.toBookEntity(): List<Book>{
    return this.map { it.toBookEntity() }
}