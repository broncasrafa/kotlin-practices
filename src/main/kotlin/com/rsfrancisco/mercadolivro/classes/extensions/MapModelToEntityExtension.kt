package com.rsfrancisco.mercadolivro.classes.extensions

import com.rsfrancisco.mercadolivro.classes.entities.Customer
import com.rsfrancisco.mercadolivro.classes.models.CustomerModel

fun CustomerModel.toCustomerEntity(): Customer {
    return Customer(
        id = this.id ?: 0, //throw IllegalArgumentException("CustomerModel.id não pode ser nulo"),
        name = this.name,
        email = this.email
    )
}