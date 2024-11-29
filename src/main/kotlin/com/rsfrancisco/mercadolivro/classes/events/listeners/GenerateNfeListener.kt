package com.rsfrancisco.mercadolivro.classes.events.listeners

import com.rsfrancisco.mercadolivro.classes.events.PurchaseEvent
import com.rsfrancisco.mercadolivro.services.PurchaseService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateNfeListener(
    private val logger: Logger = LoggerFactory.getLogger(GenerateNfeListener::class.java),
    private val purchaseService: PurchaseService
) {

    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        logger.info("[Evento recebido] Gerar NFE dos livros vendidos: PurchaseID: [${purchaseEvent.purchase.id}]")

        val nfe = UUID.randomUUID().toString()
        var purchaseEntity = purchaseEvent.purchase.copy(nfe = nfe);

        purchaseService.updateOne(purchaseEntity)
    }
}