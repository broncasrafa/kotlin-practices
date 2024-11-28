package com.rsfrancisco.mercadolivro.classes.entities

import com.rsfrancisco.mercadolivro.classes.enums.BookStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name="book")
data class Book (
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "title", length = 255, nullable = false)
    var title: String,

    @Column(name = "price", nullable = false)
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name="customer_id")
    var customer: Customer? = null
) {
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if (field == BookStatus.DELETADO || field == BookStatus.CANCELADO)
                throw Exception("Não é possível alterar um livro com o status ${field}")

            field = value
        }

    constructor(
        id: Int? = null,
        title: String,
        price: BigDecimal,
        customer: Customer? = null,
        status: BookStatus?
    ): this(id, title, price, customer) {
        this.status = status
    }

//    constructor(title: String, price: BigDecimal, customer: Customer)
//        : this(
//            id = null,
//            title = title,
//            price = price,
//            customer = customer,
//            status = BookStatus.ATIVO)
}