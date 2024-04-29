package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.iagxferreira.hexagonal.application.core.domain.Address
import com.iagxferreira.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter (
   @Autowired
   private val findAddressByZipCode: FindAddressByZipCodeClient,
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address? {
        val address = findAddressByZipCode.find(zipCode)
         return address.let { Address(street = it.street, city = it.city, state = it.state) }
    }
}