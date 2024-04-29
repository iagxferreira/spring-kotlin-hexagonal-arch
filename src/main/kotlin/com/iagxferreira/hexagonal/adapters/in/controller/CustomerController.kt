package com.iagxferreira.hexagonal.adapters.`in`.controller

import com.iagxferreira.hexagonal.adapters.`in`.controller.mapper.CustomerMapper
import com.iagxferreira.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.iagxferreira.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.iagxferreira.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.iagxferreira.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.iagxferreira.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController (
    @Autowired
    private val insertCustomerInputPort: InsertCustomerInputPort,
    @Autowired
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    @Autowired
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    @Autowired
    private val customerMapper: CustomerMapper,
){
    @PostMapping
    fun insert(
        @Valid
        @RequestBody
        customerRequest: CustomerRequest): ResponseEntity<Void> {
        val customer = customerMapper.toCustomer(customerRequest)
        insertCustomerInputPort.insert(customer, customerRequest.zipCode)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: String): ResponseEntity<CustomerResponse?>{
        val customer = findCustomerByIdInputPort.find(id)
        return ResponseEntity.ok().body(customer?.let { customerMapper.toCustomerResponse(it) })
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody customerRequest: CustomerRequest): ResponseEntity<CustomerResponse?>{
        val customer = updateCustomerInputPort.update(id, customerMapper.toCustomer(customerRequest))
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void>{
        return ResponseEntity.ok().build()
    }
}