package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.repository.CustomerRepository
import com.iagxferreira.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdAdapter (
    @Autowired
    private val customerRepository: CustomerRepository
): DeleteCustomerByIdOutputPort {
    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}