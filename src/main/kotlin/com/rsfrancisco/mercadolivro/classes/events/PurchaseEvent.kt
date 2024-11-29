package com.rsfrancisco.mercadolivro.classes.events

import com.rsfrancisco.mercadolivro.classes.entities.Purchase
import org.springframework.context.ApplicationEvent

class PurchaseEvent(source: Any, val purchase: Purchase) : ApplicationEvent(source)