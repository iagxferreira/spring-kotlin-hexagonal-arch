package com.iagxferreira.hexagonal.application.core.usecase.customer

import com.iagxferreira.hexagonal.application.ports.`in`.DeleteCustomerInputPort
import com.iagxferreira.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
): DeleteCustomerInputPort {
    override fun delete(id: String) {
        deleteCustomerByIdOutputPort.delete(id)
    }
}