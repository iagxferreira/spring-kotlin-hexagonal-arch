package com.iagxferreira.hexagonal.application.ports.out

import com.iagxferreira.hexagonal.application.core.domain.Customer

interface FindCustomerByIdOutputPort {
    fun find(id: String): Customer?
}