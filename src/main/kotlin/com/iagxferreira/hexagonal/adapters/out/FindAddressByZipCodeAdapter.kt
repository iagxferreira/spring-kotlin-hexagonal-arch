package com.iagxferreira.hexagonal.adapters.out

import com.iagxferreira.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.iagxferreira.hexagonal.adapters.out.client.mapper.AddressResponseMapper
import com.iagxferreira.hexagonal.application.core.domain.Address
import com.iagxferreira.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.beans.factory.annotation.Autowired

class FindAddressByZipCodeAdapter (
   @Autowired
   private val findAddressByZipCode: FindAddressByZipCodeClient,
    @Autowired
    private val addressResponseMapper: AddressResponseMapper
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address {
        val address = findAddressByZipCode.find(zipCode)
        return addressResponseMapper.toAddress(address)
    }

}