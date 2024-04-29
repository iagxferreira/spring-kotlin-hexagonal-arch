package com.iagxferreira.hexagonal.application.ports.out

import com.iagxferreira.hexagonal.application.core.domain.Customer

interface UpdateCustomerOutputPort {
    fun update(id: String, customer: Customer): Customer?
}