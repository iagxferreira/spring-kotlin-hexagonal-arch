package com.iagxferreira.hexagonal.adapters.out.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class CustomerEntity(
    @Id
    private val id: String,
    private val name: String,
    private val address: AddressEntity,
    private val document: String,
    private val validDocument: Boolean
)