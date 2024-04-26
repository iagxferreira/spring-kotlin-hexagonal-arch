package com.iagxferreira.hexagonal.adapters.out.client.response

data class AddressResponse  (
    private val street: String,
    private val city: String,
    private val state: String,
)