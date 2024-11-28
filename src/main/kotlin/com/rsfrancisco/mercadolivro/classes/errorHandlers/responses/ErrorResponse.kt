package com.rsfrancisco.mercadolivro.classes.errorHandlers.responses

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

//data class ErrorResponse (
//    var httpCode: Int,
//    var message: String,
//    var internalCode: String,
//    var errors: List<FieldErrorResponse>?
//)

data class ErrorResponse (
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    var timestamp: Instant = Instant.now(),
    var status: Int? = null,
    var message: String? = null,
    var path: String? = null
) {
    constructor(status: Int, message: String?, path: String?)
        : this(
            timestamp = Instant.now(),
            status = status,
            message = message,
            path = path
        )
}