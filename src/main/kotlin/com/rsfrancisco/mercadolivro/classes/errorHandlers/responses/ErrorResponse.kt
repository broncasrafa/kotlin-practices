package com.rsfrancisco.mercadolivro.classes.errorHandlers.responses

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

data class ErrorResponse (
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    var timestamp: Instant = Instant.now(),
    var status: Int? = null,
    var message: String? = null,
    var path: String? = null,
    var errors: List<FieldErrorResponse>? = null
) {
    constructor(status: Int, message: String?, path: String?)
        : this(
            timestamp = Instant.now(),
            status = status,
            message = message,
            path = path
        )
    constructor(status: Int, message: String?, errors: List<FieldErrorResponse>? = null)
            : this(
        timestamp = Instant.now(),
        status = status,
        message = message,
        errors = errors
    )
}