package com.rsfrancisco.mercadolivro.classes.extensions

import com.rsfrancisco.mercadolivro.classes.dtos.request.*
import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import com.rsfrancisco.mercadolivro.classes.models.*

fun CustomerCreateRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}
fun CustomerUpdateRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(id = this.id, name = this.name, email = this.email)
}

fun BookCreateRequest.toBookModel(customerModel: CustomerModel?): BookModel {
    return BookModel(
        title = this.title,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customerModel
    )
}
fun BookUpdateRequest.toBookModel(): BookModel {
    return BookModel(
        id = this.id,
        title = this.title,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = null
    )
}