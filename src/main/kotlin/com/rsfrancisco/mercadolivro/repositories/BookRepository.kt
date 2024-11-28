package com.rsfrancisco.mercadolivro.repositories

import com.rsfrancisco.mercadolivro.classes.entities.Book
import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Int> {
    fun findByStatus(status: BookStatus, pageable: Pageable?): Page<Book>
    fun findByTitleContainingIgnoreCase(title: String): List<Book>
    fun findByStatusAndTitleContainingIgnoreCase(status: BookStatus, title: String, pageable: Pageable?): Page<Book>
    fun findByCustomerId(customerId: Int): List<Book>
}