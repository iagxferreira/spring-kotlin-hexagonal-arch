package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.client.mapper.CustomerEntityMapper
import com.iagxferreira.hexagonal.adapters.out.repository.CustomerRepository
import com.iagxferreira.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class FindCustomerByIdAdapter(
    @Autowired
    private val customerRepository: CustomerRepository,
    @Autowired
    private val customerEntityMapper: CustomerEntityMapper
) : FindCustomerByIdOutputPort {
    override fun find(id: String): Customer? {
        val customerEntity: CustomerEntity? = customerRepository.findById(id).orElseThrow { RuntimeException("Customer not found") }
        return customerEntity?.let{ return customerEntityMapper.toCustomer(it) }
    }
}