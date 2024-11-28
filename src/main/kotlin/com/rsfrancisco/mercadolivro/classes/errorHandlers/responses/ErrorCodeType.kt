package com.rsfrancisco.mercadolivro.classes.errorHandlers.responses

enum class ErrorCodeType(val message: String, val code: String) {
    ML0001(message ="Customer with ID: '%s' was not found", code ="ML-0001"),
    ML0002(message="Book with ID: '%s' was not found", code ="ML-0002")
}