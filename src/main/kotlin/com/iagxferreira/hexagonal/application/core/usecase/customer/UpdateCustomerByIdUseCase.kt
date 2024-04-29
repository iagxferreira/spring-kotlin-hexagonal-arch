package com.iagxferreira.hexagonal.application.core.usecase.customer

import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.iagxferreira.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.iagxferreira.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.iagxferreira.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import com.iagxferreira.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
): UpdateCustomerInputPort {
    override fun update(id: String, customer: Customer, zipCode: String) {
        val foundedCustomer = findCustomerByIdOutputPort.find(id) ?: throw RuntimeException("Customer not found")
        val foundedAddress = findAddressByZipCodeOutputPort.find(zipCode)
        if (foundedAddress != null) {
            foundedCustomer.address = foundedAddress
        }
        return updateCustomerOutputPort.update(id, customer)
    }
}