package com.rsfrancisco.mercadolivro.classes.events.listeners

import com.rsfrancisco.mercadolivro.classes.events.PurchaseEvent
import com.rsfrancisco.mercadolivro.services.BookService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class ChangeBookStatusListener(
    private val logger: Logger = LoggerFactory.getLogger(ChangeBookStatusListener::class.java),
    private val bookService: BookService
) {

    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        logger.info("[Evento recebido] Atualizar status dos livros vendidos: PurchaseID: [${purchaseEvent.purchase.id}]")
        bookService.changeStatusSoldBooks(purchaseEvent.purchase.books)
    }
}