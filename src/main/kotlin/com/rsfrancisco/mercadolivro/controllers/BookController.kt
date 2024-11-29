package com.rsfrancisco.mercadolivro.controllers

import com.rsfrancisco.mercadolivro.classes.dtos.request.BookCreateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.request.BookUpdateRequest
import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.mappers.toBookEntity
import com.rsfrancisco.mercadolivro.classes.mappers.toCustomerEntity
import com.rsfrancisco.mercadolivro.services.BookService
import com.rsfrancisco.mercadolivro.services.CustomerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("books")
@Tag(name = "Books", description = "Books related endpoints")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @Operation(summary = "Get the list of paginated active books", description = "This endpoint returns the list of paginated active books.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getBooks(@Parameter(description = "Name of books to be fetched. (Optional)") @RequestParam name: String?, @PageableDefault(page = 0, size = 5) pageable: Pageable?): Page<BookResponse> {
        return bookService.getAll(name, pageable)
    }


    @Operation(summary = "Get a book by the specified ID", description = "This endpoint returns a book by the specified ID.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getBookById(@Parameter(description = "ID of book that needs to be fetched") @PathVariable id: Int): BookResponse {
        return bookService.getById(id)
    }


    @Operation(summary = "Add a new book", description = "This endpoint create a new book.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody request: BookCreateRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.insertOne(request.toBookEntity(customer!!.toCustomerEntity()))
    }


    @Operation(summary = "Update an existing book by the specified ID", description = "This endpoint update an existing book by the specified ID.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@RequestBody request: BookUpdateRequest, @Parameter(description = "ID of book that needs to be updated") @PathVariable id: Int) {
        bookService.updateOne(request.toBookEntity(), id)
    }


    @Operation(summary = "Deletes an existing book by the specified ID", description = "This endpoint deletes an existing book by the specified ID.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@Parameter(description = "ID of book that needs to be deleted") @PathVariable id: Int) {
        bookService.deleteOne(id)
    }
}