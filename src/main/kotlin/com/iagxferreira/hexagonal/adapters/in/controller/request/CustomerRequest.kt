package com.iagxferreira.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

class CustomerRequest (
    @NotBlank
    public val name: String,
    @NotBlank
    public val document: String,
    @NotBlank
    public val zipCode: String,
)