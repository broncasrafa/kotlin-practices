package com.rsfrancisco.mercadolivro.controllers

import com.rsfrancisco.mercadolivro.classes.dtos.request.BookCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.BookUpdateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.extensions.*
import com.rsfrancisco.mercadolivro.services.BookService
import com.rsfrancisco.mercadolivro.services.CustomerService

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getBooks(@RequestParam name: String?): List<BookResponse> {
        var response = bookService.getAll(name)
        return response.toBookResponse()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getBookById(@PathVariable id: Int): BookResponse {
        var response = bookService.getById(id)
        return response.toBookResponse()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody request: BookCreateRequest): BookResponse {
        val customer = customerService.getById(request.customerId)
        var response = bookService.insertOne(request.toBookModel(customer))
        return response!!.toBookResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@RequestBody request: BookUpdateRequest, @PathVariable id: Int) {
        bookService.updateOne(request.toBookModel(), id)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) {
        bookService.deleteOne(id)
    }
}