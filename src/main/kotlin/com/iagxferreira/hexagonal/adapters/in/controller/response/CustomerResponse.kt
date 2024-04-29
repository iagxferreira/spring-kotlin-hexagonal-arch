package com.iagxferreira.hexagonal.adapters.`in`.controller.response

data class CustomerResponse(
    private val name: String,
    private val address: AddressResponse,
    private val document: String
)