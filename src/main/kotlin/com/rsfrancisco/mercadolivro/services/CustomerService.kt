package com.rsfrancisco.mercadolivro.services

import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerUpdateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.dtos.response.CustomerResponse
import com.rsfrancisco.mercadolivro.classes.enums.CustomerStatus
import com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions.CustomerNotFoundException
import com.rsfrancisco.mercadolivro.classes.mappers.toCustomerEntity
import com.rsfrancisco.mercadolivro.classes.mappers.toCustomerResponse
import com.rsfrancisco.mercadolivro.repositories.CustomerRepository

import jakarta.transaction.Transactional

import org.springframework.stereotype.Service

@Service
class CustomerService(val repository: CustomerRepository, val bookService: BookService) {

    fun getAll(name: String?): List<CustomerResponse> {
        name?.let {
            return repository.findByNameContainingIgnoreCase(name).map { it.toCustomerResponse() }
        }
        return repository.findAll().map{ it.toCustomerResponse() }
    }

    @Transactional
    fun getById(id: Int): CustomerResponse? {
        var customer = repository.findById(id)
                                    .orElseThrow { CustomerNotFoundException(id) }
        return customer.toCustomerResponse()
    }

    fun insertOne(request: CustomerCreateRequest): CustomerResponse {
        val customer = request.toCustomerEntity()
        return repository.save(customer).toCustomerResponse()
    }

    fun updateOne(model: CustomerUpdateRequest, id: Int) {
        var customCustomer = repository.findById(id)
                                            .orElseThrow { CustomerNotFoundException(id) }

        customCustomer.let {
            it.name = model.name
            it.email = model.email
        }
        repository.save(customCustomer);
    }

    fun deleteOne(id: Int) {
        var customCustomer = repository.findById(id)
                                            .orElseThrow { CustomerNotFoundException(id) }

        customCustomer.status = CustomerStatus.INATIVO

        bookService.deleteByCustomerId(id)

        repository.save(customCustomer)
    }

    fun getCustomerBooks(customerId: Int): List<BookResponse> {
        return bookService.getByCustomerId(customerId)
    }
}