package com.rsfrancisco.mercadolivro.classes.mappers

import com.rsfrancisco.mercadolivro.classes.dtos.request.PurchaseCreateRequest
import com.rsfrancisco.mercadolivro.classes.entities.Purchase
import com.rsfrancisco.mercadolivro.services.BookService
import com.rsfrancisco.mercadolivro.services.CustomerService
import org.springframework.stereotype.Component


@Component
class PurchaseMapper(
    private val customerService: CustomerService,
    private val bookService: BookService
) {
    fun toEntity(request: PurchaseCreateRequest): Purchase {
        val customer = customerService.getById(request.customerId)
        val books = bookService.getAllByIds(request.bookIds)
        return Purchase(
            customer = customer!!.toCustomerEntity(),
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }
}