package com.rsfrancisco.mercadolivro.classes.entities

import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name="book")
data class Book (
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "title", length = 255, nullable = false)
    var title: String,

    @Column(name = "price", nullable = false)
    var price: BigDecimal,

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null,

    @ManyToOne
    @JoinColumn(name="customer_id")
    var customer: Customer? = null
)