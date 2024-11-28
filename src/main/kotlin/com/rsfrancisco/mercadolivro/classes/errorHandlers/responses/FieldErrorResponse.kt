package com.rsfrancisco.mercadolivro.classes.errorHandlers.responses

data class FieldErrorResponse (
    var message: String,
    var field: String
)