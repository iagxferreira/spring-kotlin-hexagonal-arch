package com.iagxferreira.hexagonal.adapters.`in`.controller

import com.iagxferreira.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.iagxferreira.hexagonal.adapters.out.client.response.AddressResponse
import com.iagxferreira.hexagonal.adapters.out.client.response.CustomerResponse
import com.iagxferreira.hexagonal.application.core.domain.Address
import com.iagxferreira.hexagonal.application.core.domain.Customer
import com.iagxferreira.hexagonal.application.ports.`in`.DeleteCustomerInputPort
import com.iagxferreira.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.iagxferreira.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.iagxferreira.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    @Autowired
    private val insertCustomerInputPort: InsertCustomerInputPort,
    @Autowired
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    @Autowired
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    @Autowired
    private val deleteCustomerInputPort: DeleteCustomerInputPort,
) {
    @PostMapping
    fun insert(
        @Valid
        @RequestBody
        customerRequest: CustomerRequest,
    ): ResponseEntity<Void> {
        customerRequest.let {
            insertCustomerInputPort.insert(
                Customer(
                    name = it.name,
                    document = it.document,
                    address = Address("", "", "")
                ),
                it.zipCode
            )
        }
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: String): ResponseEntity<CustomerResponse?> {
        val customer = findCustomerByIdInputPort.find(id)
        return ResponseEntity.ok().body(customer?.let {
            CustomerResponse(
                name = it.name,
                document = it.document,
                address = AddressResponse(
                    city = it.address.city,
                    state = it.address.state,
                    street = it.address.street,
                    cep = "",
                    service = "",
                    neighborhood = ""
                )
            )
        })
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @Valid @RequestBody customerRequest: CustomerRequest,
    ): ResponseEntity<CustomerResponse?> {
        customerRequest.let {
            updateCustomerInputPort.update(
                id,
                Customer(
                    name = it.name,
                    address = Address("", "", ""),
                    document = it.document,
                    validDocument = true
                ),
                it.zipCode
            )
        }
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void> {
        deleteCustomerInputPort.delete(id)
        return ResponseEntity.ok().build()
    }
}