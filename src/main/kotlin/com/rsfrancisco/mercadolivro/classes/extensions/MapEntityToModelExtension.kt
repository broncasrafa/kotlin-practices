package com.rsfrancisco.mercadolivro.classes.extensions

import com.rsfrancisco.mercadolivro.classes.entities.Customer
import com.rsfrancisco.mercadolivro.classes.models.CustomerModel

fun Customer.toCustomerModel(): CustomerModel {
    return CustomerModel(
        id = this.id ,
        name = this.name,
        email = this.email
    )
}