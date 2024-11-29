package com.rsfrancisco.mercadolivro.controllers

import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.CustomerUpdateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.dtos.response.CustomerResponse
import com.rsfrancisco.mercadolivro.classes.dtos.response.PurchaseResponse
import com.rsfrancisco.mercadolivro.services.CustomerService
import com.rsfrancisco.mercadolivro.services.PurchaseService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("customers")
@Tag(name = "Customers", description = "Customers related endpoints")
class CustomerController(
    val customerService: CustomerService,
    private val purchaseService: PurchaseService)
{

    @Operation(summary = "Get the list of customers", description = "This endpoint returns the list of clients.")
    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAll(name)
    }

    @Operation(summary = "Get a customer by the specified ID", description = "This endpoint returns a customer by the specified ID.")
    @GetMapping("/{id}")
    fun getCustomerById(@Parameter(description = "ID of customer that needs to be fetched") @PathVariable id: Int): CustomerResponse? {
        return customerService.getById(id)
    }


    @Operation(summary = "Get the list of customer books by the specified customer ID", description = "This endpoint returns the list of customer books by the specified customer ID.")
    @GetMapping("/{id}/books")
    fun getCustomerBooksById(@Parameter(description = "ID of the customer who needs to have the books fetched") @PathVariable id: Int): List<BookResponse> {
        return customerService.getCustomerBooks(id)
    }


    @Operation(summary = "Get the list of customer purchases by the specified customer ID", description = "This endpoint returns the list of customer purchases by the specified customer ID.")
    @GetMapping("/{id}/purchases")
    fun getCustomerPurchasesById(@Parameter(description = "ID of the customer who needs to have the purchases fetched") @PathVariable id: Int): List<PurchaseResponse> {
        return purchaseService.getCustomerPurchases(id)
    }



    @Operation(summary = "Add a new customer", description = "This endpoint create a new customer.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody @Valid request: CustomerCreateRequest): CustomerResponse {
        return customerService.insertOne(request)
    }


    @Operation(summary = "Update an existing customer by the specified ID", description = "This endpoint update an existing customer by the specified ID.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@RequestBody @Valid request: CustomerUpdateRequest, @Parameter(description = "ID of customer that needs to be updated") @PathVariable id: Int) {
        customerService.updateOne(request, id)
    }


    @Operation(summary = "Deletes an existing customer by the specified ID", description = "This endpoint deletes an existing customer by the specified ID.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@Parameter(description = "ID of customer that needs to be deleted") @PathVariable id: Int) {
        customerService.deleteOne(id)
    }
}