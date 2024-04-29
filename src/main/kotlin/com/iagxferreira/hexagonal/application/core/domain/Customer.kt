package com.iagxferreira.hexagonal.application.core.domain

data class Customer (
    var name: String,
    var address : Address,
    var document: String,
    var validDocument: Boolean = false,
)