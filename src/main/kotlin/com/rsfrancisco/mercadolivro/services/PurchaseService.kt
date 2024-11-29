package com.rsfrancisco.mercadolivro.services

import com.rsfrancisco.mercadolivro.classes.entities.Purchase
import com.rsfrancisco.mercadolivro.repositories.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository
) {

    fun insertOne(purchase: Purchase) {
        purchaseRepository.save(purchase)
    }
}