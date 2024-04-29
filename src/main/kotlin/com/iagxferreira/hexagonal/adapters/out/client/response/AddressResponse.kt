package com.iagxferreira.hexagonal.adapters.out.client.response

data class AddressResponse  (
    val cep: String,
    val state: String,
    val city: String,
    val neighborhood: String,
    val street: String,
    val service: String,

)