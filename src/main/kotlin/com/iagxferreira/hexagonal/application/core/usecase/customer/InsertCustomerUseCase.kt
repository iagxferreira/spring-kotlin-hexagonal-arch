package com.iagxferreira.hexagonal.application.core.usecase.customer

import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.iagxferreira.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.iagxferreira.hexagonal.application.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
): InsertCustomerInputPort {
    override fun insert(customer: Customer, zipCode: String) {
        val address = findAddressByZipCodeOutputPort.find(zipCode)
        if (address != null) {
            customer.address = address
        }
        insertCustomerOutputPort.insert(customer)
    }
}