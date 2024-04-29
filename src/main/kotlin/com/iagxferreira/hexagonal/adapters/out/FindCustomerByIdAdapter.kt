package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.repository.CustomerRepository
import com.iagxferreira.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.iagxferreira.hexagonal.application.core.domain.Address
import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class FindCustomerByIdAdapter(
    @Autowired
    private val customerRepository: CustomerRepository,
) : FindCustomerByIdOutputPort {
    override fun find(id: String): Customer? {
        val customerEntity: CustomerEntity? = customerRepository.findById(id).orElseThrow { RuntimeException("Customer not found") }
        return customerEntity?.let{
            return Customer(
                name = it.name,
                document = it.document,
                validDocument = it.validDocument,
                address = Address(
                    state = it.address.state,
                    city = it.address.city,
                    street = it.address.street
                )
            )
        }
    }
}