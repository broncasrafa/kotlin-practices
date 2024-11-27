package com.rsfrancisco.mercadolivro.classes.extensions

import com.rsfrancisco.mercadolivro.classes.dtos.response.CustomerResponse
import com.rsfrancisco.mercadolivro.classes.models.CustomerModel

fun CustomerModel.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(id = this.id!!.toInt(), name = this.name, email = this.email)
}
fun List<CustomerModel>.toCustomerResponse(): List<CustomerResponse> {
    return this.map { it.toCustomerResponse() }
}