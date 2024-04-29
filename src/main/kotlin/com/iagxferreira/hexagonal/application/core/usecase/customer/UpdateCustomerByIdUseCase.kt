package com.iagxferreira.hexagonal.application.core.usecase.customer

import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.iagxferreira.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.iagxferreira.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerByIdUseCase(
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
): UpdateCustomerInputPort {
    override fun update(id: String, customer: Customer): Customer? {
        return updateCustomerOutputPort.update(id, customer)
    }
}