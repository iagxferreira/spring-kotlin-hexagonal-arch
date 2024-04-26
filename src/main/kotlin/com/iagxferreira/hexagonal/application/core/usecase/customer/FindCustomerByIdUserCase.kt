package com.iagxferreira.hexagonal.application.core.usecase.customer

import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUserCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
){
    fun find(id: String): Customer {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow { RuntimeException("Customer not found") }
    }
}