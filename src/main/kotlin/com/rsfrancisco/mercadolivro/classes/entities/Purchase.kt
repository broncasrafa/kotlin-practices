package com.rsfrancisco.mercadolivro.classes.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity(name="purchase")
data class Purchase (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name="customer_id")
    val customer: Customer,

    @ManyToMany
    @JoinTable(
        name="purchase_book",
        joinColumns = [JoinColumn(name="purchase_id")],
        inverseJoinColumns = [JoinColumn(name="book_id")])
    val books: MutableList<Book>,

    @Column(name="price", nullable = false)
    val price: BigDecimal,

    @Column(name="nfe")
    val nfe: String? = null,

    @Column(name="createdAt", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)