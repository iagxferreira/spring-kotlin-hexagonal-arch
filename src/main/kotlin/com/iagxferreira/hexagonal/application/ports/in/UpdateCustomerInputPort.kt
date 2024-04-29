package com.iagxferreira.hexagonal.application.ports.`in`

import com.iagxferreira.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {
    fun update(id: String, customer: Customer, zipCode: String)
}