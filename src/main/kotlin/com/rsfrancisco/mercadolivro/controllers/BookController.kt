package com.rsfrancisco.mercadolivro.controllers

import com.rsfrancisco.mercadolivro.classes.dtos.request.BookCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.BookUpdateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.extensions.*
import com.rsfrancisco.mercadolivro.classes.mappers.toBookEntity
import com.rsfrancisco.mercadolivro.classes.mappers.toCustomerEntity
import com.rsfrancisco.mercadolivro.services.BookService
import com.rsfrancisco.mercadolivro.services.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault

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
    fun getBooks(@RequestParam name: String?, @PageableDefault(page = 0, size = 5) pageable: Pageable?): Page<BookResponse> {
        return bookService.getAll(name, pageable)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getBookById(@PathVariable id: Int): BookResponse {
        return bookService.getById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody request: BookCreateRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.insertOne(request.toBookEntity(customer!!.toCustomerEntity()))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@RequestBody request: BookUpdateRequest, @PathVariable id: Int) {
        bookService.updateOne(request.toBookEntity(), id)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) {
        bookService.deleteOne(id)
    }
}