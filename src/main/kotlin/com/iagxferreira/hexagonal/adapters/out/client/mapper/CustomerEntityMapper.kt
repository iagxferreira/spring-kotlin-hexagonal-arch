package com.iagxferreira.hexagonal.adapters.out.client.mapper

import com.iagxferreira.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.iagxferreira.hexagonal.application.core.domain.Customer
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CustomerEntityMapper {
    fun toCustomerEntity(customer: Customer): CustomerEntity
    fun toCustomer(customerEntity: CustomerEntity) : Customer
}