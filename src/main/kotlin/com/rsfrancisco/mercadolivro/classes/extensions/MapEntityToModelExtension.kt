package com.rsfrancisco.mercadolivro.classes.extensions

import com.rsfrancisco.mercadolivro.classes.entities.Book
import com.rsfrancisco.mercadolivro.classes.entities.Customer
import com.rsfrancisco.mercadolivro.classes.models.BookModel
import com.rsfrancisco.mercadolivro.classes.models.CustomerModel

fun Customer.toCustomerModel(): CustomerModel {
    return CustomerModel(
        id = this.id,
        name = this.name,
        email = this.email
    )
}

fun Book.toBookModel(): BookModel {
    return BookModel(
        id = this.id,
        title = this.title,
        price = this.price,
        status = this.status,
        customer = this.customer!!.toCustomerModel()
    )
}