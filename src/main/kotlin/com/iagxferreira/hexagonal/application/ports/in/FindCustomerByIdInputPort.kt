package com.iagxferreira.hexagonal.application.ports.`in`

import com.iagxferreira.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {
    fun find(id: String): Customer?
}