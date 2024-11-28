package com.rsfrancisco.mercadolivro.controllers

import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerUpdateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.dtos.response.CustomerResponse
import com.rsfrancisco.mercadolivro.services.CustomerService
import jakarta.validation.Valid

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("customers")
class CustomerController(val customerService: CustomerService)
{
    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Int): CustomerResponse? {
        return customerService.getById(id)
    }


    @GetMapping("/{id}/books")
    fun getCustomerBooksById(@PathVariable id: Int): List<BookResponse> {
        return customerService.getCustomerBooks(id)
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid request: CustomerCreateRequest): CustomerResponse {
        return customerService.insertOne(request)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@RequestBody @Valid request: CustomerUpdateRequest, @PathVariable id: Int) {
        customerService.updateOne(request, id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteOne(id)
    }
}