package com.iagxferreira.hexagonal.adapters.`in`.controller.mapper

import com.iagxferreira.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.iagxferreira.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.iagxferreira.hexagonal.application.core.domain.Customer
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "documentValid", ignore = true)
    fun toCustomer(customerRequest: CustomerRequest): Customer

    fun toCustomerResponse(customer: Customer): CustomerResponse
}