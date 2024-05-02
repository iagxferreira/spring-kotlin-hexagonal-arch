package com.iagxferreira.hexagonal.adapters.out.client.response


data class CustomerResponse(
    val name: String,
    val address: AddressResponse,
    val document: String
)