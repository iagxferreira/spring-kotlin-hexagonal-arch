package com.iagxferreira.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

class CustomerRequest (
    @NotBlank
    val name: String,
    @NotBlank
    val document: String,
    @NotBlank
    val zipCode: String,
)