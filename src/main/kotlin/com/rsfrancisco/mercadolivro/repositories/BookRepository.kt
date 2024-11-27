package com.rsfrancisco.mercadolivro.repositories

import com.rsfrancisco.mercadolivro.classes.entities.Book
import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int> {
    fun findByStatus(status: BookStatus): List<Book>
    fun findByTitleContainingIgnoreCase(title: String): List<Book>
    fun findByStatusAndTitleContainingIgnoreCase(status: BookStatus, title: String): List<Book>
    fun findByCustomerId(customerId: Int): List<Book>
}