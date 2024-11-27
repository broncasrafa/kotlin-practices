package com.rsfrancisco.mercadolivro.classes.extensions

import com.rsfrancisco.mercadolivro.classes.entities.*
import com.rsfrancisco.mercadolivro.classes.models.*

fun CustomerModel.toCustomerEntity(): Customer {
    return Customer(
        id = this.id ?: 0,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toBookEntity(): Book {
    return Book(
        id = this.id ?: 0,
        title = this.title,
        price = this.price,
        status = this.status,
    )
}