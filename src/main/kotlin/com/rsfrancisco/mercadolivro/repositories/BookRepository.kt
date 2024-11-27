package com.rsfrancisco.mercadolivro.repositories

import com.rsfrancisco.mercadolivro.classes.entities.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface BookRepository : JpaRepository<Book, Int> {
}