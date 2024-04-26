package com.iagxferreira.hexagonal.application.ports.`in`

import com.iagxferreira.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {
    fun insert(customer: Customer, zipCode: String)
}