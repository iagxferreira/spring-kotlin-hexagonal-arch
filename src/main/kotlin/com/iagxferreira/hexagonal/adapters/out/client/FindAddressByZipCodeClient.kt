package com.iagxferreira.hexagonal.adapters.out.client

import com.iagxferreira.hexagonal.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "FindAddressByZipCodeClient",
    url = "http://localhost:8002/addresses"
)
interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}")
    fun find(@PathVariable("zipCode")zipCode: String): AddressResponse
}