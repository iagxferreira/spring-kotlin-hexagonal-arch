package com.iagxferreira.hexagonal.adapters.out.client.mapper

import com.iagxferreira.hexagonal.adapters.out.client.response.AddressResponse
import com.iagxferreira.hexagonal.application.core.domain.Address
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface AddressResponseMapper {
    fun toAddress(addressResponse: AddressResponse): Address
}