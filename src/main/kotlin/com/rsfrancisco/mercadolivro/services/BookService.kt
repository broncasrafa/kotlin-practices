package com.rsfrancisco.mercadolivro.services

import com.rsfrancisco.mercadolivro.classes.dtos.response.BookResponse
import com.rsfrancisco.mercadolivro.classes.entities.Book
import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import com.rsfrancisco.mercadolivro.classes.errorHandlers.exceptions.BookNotFoundException
import com.rsfrancisco.mercadolivro.classes.mappers.toBookResponse
import com.rsfrancisco.mercadolivro.repositories.BookRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {

    fun getAll(name: String?, pageable: Pageable?): Page<BookResponse> {
        name?.let {
            return bookRepository.findByStatusAndTitleContainingIgnoreCase(BookStatus.ATIVO, name, pageable)
                .map { it.toBookResponse() }
        }
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable).map { it.toBookResponse() }
    }

    fun getById(id: Int): BookResponse {
        return bookRepository.findById(id)
                                .orElseThrow { BookNotFoundException(id) }
                             .toBookResponse()
    }

    fun getByCustomerId(customerId: Int): List<BookResponse> {
        return bookRepository.findByCustomerId(customerId).map { it.toBookResponse() }
    }


    @Transactional
    fun insertOne(entity: Book) {
        bookRepository.save(entity)
    }

    fun updateOne(model: Book, id: Int) {
        var currentBook = bookRepository.findById(id)
                                            .orElseThrow { BookNotFoundException(id) }

        currentBook?.let {
            it.title = model.title ?: currentBook.title
            it.price = model.price ?: currentBook.price
        }

        bookRepository.save(currentBook)
    }

    fun deleteOne(id: Int) {
        var book = bookRepository.findById(id).orElseThrow { BookNotFoundException(id) }
        book.status = BookStatus.CANCELADO
        bookRepository.save(book)
    }

    fun deleteByCustomerId(customerId: Int) {
        var books = bookRepository.findByCustomerId(customerId)
        for(book in books) {
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }

    fun getAllByIds(bookIds: Set<Int>): List<Book> {
        return bookRepository.findAllById(bookIds).toList()
    }

    fun changeStatusSoldBooks(books: MutableList<Book>) {
        books.map { it.status = BookStatus.VENDIDO}
        bookRepository.saveAll(books)
    }

    fun getInactiveBookIds(bookIds: Set<Int>): List<Book> {
        return getAllByIds(bookIds).filter { it.status != BookStatus.ATIVO }
    }
}