package com.rsfrancisco.mercadolivro.services

import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import com.rsfrancisco.mercadolivro.classes.extensions.toBookEntity
import com.rsfrancisco.mercadolivro.classes.extensions.toBookModel
import com.rsfrancisco.mercadolivro.classes.extensions.toCustomerEntity
import com.rsfrancisco.mercadolivro.classes.models.BookModel
import com.rsfrancisco.mercadolivro.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {

    fun getAll(name: String?): List<BookModel> {
        name?.let {
            return bookRepository.findByStatusAndTitleContainingIgnoreCase(BookStatus.ATIVO, name)
                .map { it.toBookModel() }
        }
        return bookRepository.findByStatus(BookStatus.ATIVO).map { it.toBookModel() }
    }

    fun getById(id: Int): BookModel {
        var book = bookRepository.findById(id).orElseThrow()
        return book.toBookModel()
    }


    fun insertOne(model: BookModel): BookModel {
        var book = model.toBookEntity()
        book.customer = model.customer!!.toCustomerEntity()

        var newBook = bookRepository.save(book)
        return newBook.toBookModel()
    }

    fun updateOne(model: BookModel, id: Int) {
        var currentBook = bookRepository.findById(id).orElseThrow()

        currentBook?.let {
            it.title = model.title ?: currentBook.title
            it.price = model.price ?: currentBook.price
        }

        bookRepository.save(currentBook)
    }

    fun deleteOne(id: Int) {
        var book = bookRepository.findById(id).orElseThrow()
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
}