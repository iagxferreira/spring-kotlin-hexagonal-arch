package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.repository.CustomerRepository
import com.iagxferreira.hexagonal.adapters.out.repository.entity.AddressEntity
import com.iagxferreira.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class InsertCustomerAdapter(
    @Autowired
    private val customerRepository: CustomerRepository,
) : InsertCustomerOutputPort {
    override fun insert(customer: Customer) {
        customer.let {
            customerRepository.save(
                CustomerEntity(
                    id = UUID.randomUUID().toString(),
                    name = it.name,
                    document = it.document,
                    validDocument = it.validDocument,
                    address = AddressEntity(
                        street = it.address.street,
                        city = it.address.city,
                        state = it.address.state
                    ),
                )
            )
        }
    }
}