package com.iagxferreira.hexagonal.adapters.out.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "customers")
data class CustomerEntity(
    @Id
    val id: String,
    val name: String,
    val address: AddressEntity,
    val document: String,
    val validDocument: Boolean
)