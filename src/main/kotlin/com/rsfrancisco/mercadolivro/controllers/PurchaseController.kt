package com.rsfrancisco.mercadolivro.controllers

import com.rsfrancisco.mercadolivro.classes.dtos.request.PurchaseCreateRequest
import com.rsfrancisco.mercadolivro.classes.mappers.PurchaseMapper
import com.rsfrancisco.mercadolivro.services.PurchaseService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("purchases")
@Tag(name = "Purchases", description = "Purchases related endpoints")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
    ) {

    @Operation(summary = "Add a new purchase", description = "This endpoint create a new purchase.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPurchase(@RequestBody @Valid request: PurchaseCreateRequest) {
        purchaseService.insertOne(purchaseMapper.toEntity(request))
    }
}