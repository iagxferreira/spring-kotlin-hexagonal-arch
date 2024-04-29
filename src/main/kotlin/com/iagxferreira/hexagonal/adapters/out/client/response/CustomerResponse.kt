package com.iagxferreira.hexagonal.adapters.out.client.response


data class CustomerResponse(
    private val name: String,
    private val address: AddressResponse,
    private val document: String
)