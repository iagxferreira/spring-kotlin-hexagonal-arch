package com.iagxferreira.hexagonal.application.core.usecase.customer

import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.iagxferreira.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.iagxferreira.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
): UpdateCustomerInputPort {
    override fun update(id: String, customer: Customer): Customer? {
        val foundedCustomer = findCustomerByIdInputPort.find(id) ?: throw RuntimeException("Customer not found")
        return updateCustomerOutputPort.update(id, customer)
    }
}