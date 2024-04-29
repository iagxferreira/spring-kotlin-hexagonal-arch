package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.repository.CustomerRepository
import com.iagxferreira.hexagonal.adapters.out.repository.entity.AddressEntity
import com.iagxferreira.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    @Autowired
    private val customerRepository: CustomerRepository,
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(
            id = "",
            name = customer.name,
            document = customer.document,
            validDocument = customer.validDocument,
            address = AddressEntity(
                street = customer.address.street,
                city = customer.address.city,
                state = customer.address.state
            ),
        ))
    }
}