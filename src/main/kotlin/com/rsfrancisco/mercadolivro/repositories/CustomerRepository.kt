package com.rsfrancisco.mercadolivro.repositories

import com.rsfrancisco.mercadolivro.classes.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : JpaRepository<Customer, Int> {
    fun findByNameContainingIgnoreCase(name: String): List<Customer>
}