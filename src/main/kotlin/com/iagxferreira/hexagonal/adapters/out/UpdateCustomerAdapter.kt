package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.repository.CustomerRepository
import com.iagxferreira.hexagonal.adapters.out.repository.entity.AddressEntity
import com.iagxferreira.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    @Autowired
    private val customerRepository: CustomerRepository,
) : UpdateCustomerOutputPort {
    override fun update(id: String, customer: Customer) {
        customer.let {
            customerRepository.save(
                CustomerEntity(
                    id,
                    name = it.name,
                    document = it.document,
                    validDocument = it.validDocument,
                    address = AddressEntity(
                        street = it.address.street,
                        state = it.address.state,
                        city = it.address.city
                    ),
                )
            )
        }
    }
}