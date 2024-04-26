package com.iagxferreira.hexagonal.application.core.domain

data class Customer (
    private val id : String,
    private val name: String,
    var address : Address,
    private val document: String,
    private val documentValid: Boolean = false,
)