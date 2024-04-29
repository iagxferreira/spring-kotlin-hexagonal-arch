package com.iagxferreira.hexagonal.adapters.`in`.controller

import com.iagxferreira.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.iagxferreira.hexagonal.adapters.out.client.response.AddressResponse
import com.iagxferreira.hexagonal.adapters.out.client.response.CustomerResponse
import com.iagxferreira.hexagonal.application.core.domain.Address
import com.iagxferreira.hexagonal.application.core.domain.Customer
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
    ){
    @PostMapping
    fun insert(
        @Valid
        @RequestBody
        customerRequest: CustomerRequest): ResponseEntity<Void> {
        val customer = Customer(name = customerRequest.name, document = customerRequest.document, address = Address("", "", "",))
        insertCustomerInputPort.insert(customer, customerRequest.zipCode)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: String): ResponseEntity<CustomerResponse?>{
        val customer = findCustomerByIdInputPort.find(id)
        return ResponseEntity.ok().body(customer?.let {
                CustomerResponse(
                    name = customer.name,
                    document =  customer.document,
                    address =  AddressResponse(
                        city = customer.address.city,
                        state = customer.address.state,
                        street = customer.address.street,
                        cep = "",
                        service = "",
                        neighborhood = ""
                    )
                )
            }
        )
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @Valid @RequestBody customerRequest: CustomerRequest): ResponseEntity<CustomerResponse?>{
        updateCustomerInputPort.update(id, Customer(name= customerRequest.name, address= Address("", "", "",), document = customerRequest.document, validDocument = true ), customerRequest.zipCode)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void>{
        return ResponseEntity.ok().build()
    }
}