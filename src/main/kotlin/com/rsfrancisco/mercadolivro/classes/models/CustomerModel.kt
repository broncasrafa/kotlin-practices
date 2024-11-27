package com.rsfrancisco.mercadolivro.classes.models

/*
* Data classes - tem como objetivo representar dados de uma forma estruturada. Porém sem a necessidade de se
* definir toString, equals, hashCode, getters e setters e outros métodos
* */
data class CustomerModel(
    var id: Int? = null,
    var name: String,
    var email: String
)