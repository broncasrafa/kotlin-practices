package com.rsfrancisco.mercadolivro.classes.entities

import jakarta.persistence.*

@Entity
@Table(name="customer")
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "name", length = 255, nullable = false)
    var name: String,

    @Column(name = "email", length = 255, nullable = false, unique = true)
    var email: String
) {
    constructor() : this(id =0, name ="", email ="")
}