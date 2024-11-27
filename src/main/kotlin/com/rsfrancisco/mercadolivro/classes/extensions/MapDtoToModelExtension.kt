package com.rsfrancisco.mercadolivro.classes.extensions

import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerUpdateRequest
import com.rsfrancisco.mercadolivro.classes.models.CustomerModel

fun CustomerCreateRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}
fun CustomerUpdateRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(id = this.id, name = this.name, email = this.email)
}