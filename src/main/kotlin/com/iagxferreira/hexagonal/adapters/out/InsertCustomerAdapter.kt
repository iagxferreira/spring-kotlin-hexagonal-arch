package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.client.mapper.CustomerEntityMapper
import com.iagxferreira.hexagonal.adapters.out.repository.CustomerRepository
import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    @Autowired
    private val customerRepository: CustomerRepository,
    @Autowired
    private val customerEntityMapper: CustomerEntityMapper,
): InsertCustomerOutputPort {



    override fun insert(customer: Customer) {
        val customerEntity = customerEntityMapper.toCustomerEntity(customer)
        customerRepository.save(customerEntity)
    }
}