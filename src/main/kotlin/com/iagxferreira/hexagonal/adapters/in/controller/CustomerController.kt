package com.iagxferreira.hexagonal.adapters.`in`.controller

import com.iagxferreira.hexagonal.adapters.`in`.controller.mapper.CustomerMapper
import com.iagxferreira.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.iagxferreira.hexagonal.application.ports.`in`.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController (
    @Autowired
    private val insertCustomerInputPort: InsertCustomerInputPort,
    @Autowired
    private val customerMapper: CustomerMapper,
){
    fun insert(
        @Valid
        @RequestBody
        customerRequest: CustomerRequest): ResponseEntity<Void> {
        val customer = customerMapper.toCustomer(customerRequest)
        insertCustomerInputPort.insert(customer, customerRequest.zipCode)
        return ResponseEntity.ok().build()
    }
}