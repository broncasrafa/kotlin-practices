package com.rsfrancisco.mercadolivro.repositories

import com.rsfrancisco.mercadolivro.classes.entities.Purchase
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository : JpaRepository<Purchase, Int> {
}