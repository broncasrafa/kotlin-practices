package com.rsfrancisco.mercadolivro.controllers

import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerUpdateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.response.CustomerResponse
import com.rsfrancisco.mercadolivro.classes.extensions.toCustomerModel
import com.rsfrancisco.mercadolivro.classes.extensions.toCustomerResponse
import com.rsfrancisco.mercadolivro.services.CustomerService

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("customers")
class CustomerController(val customerService: CustomerService)
{
    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerResponse> {
        val response = customerService.getAll(name)
        return response.toCustomerResponse()
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Int): CustomerResponse {
        val response = customerService.getById(id)
        return response!!.toCustomerResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody request: CustomerCreateRequest): CustomerResponse {
        val response = customerService.insertOne(request.toCustomerModel())
        return response.toCustomerResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@RequestBody request: CustomerUpdateRequest, @PathVariable id: Int) {
        customerService.updateOne(request.toCustomerModel(), id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteOne(id)
    }
}