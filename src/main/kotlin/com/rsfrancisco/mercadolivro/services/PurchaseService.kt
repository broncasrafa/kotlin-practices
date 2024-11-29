package com.rsfrancisco.mercadolivro.services

import com.rsfrancisco.mercadolivro.classes.entities.Purchase
import com.rsfrancisco.mercadolivro.classes.events.PurchaseEvent
import com.rsfrancisco.mercadolivro.repositories.PurchaseRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val logger: Logger = LoggerFactory.getLogger(PurchaseService::class.java),
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun insertOne(purchase: Purchase) {
        purchaseRepository.save(purchase)

        logger.info("[Publish Event] Publicando um evento de purchase. PurchaseID: [${purchase.id}]")
        applicationEventPublisher.publishEvent(PurchaseEvent(source = this, purchase = purchase))
    }

    fun updateOne(purchase: Purchase) {
        purchaseRepository.save(purchase)
    }
}