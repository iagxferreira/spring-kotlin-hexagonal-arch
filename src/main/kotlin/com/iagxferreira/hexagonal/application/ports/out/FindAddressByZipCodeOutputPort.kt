package com.iagxferreira.hexagonal.application.ports.out

import com.iagxferreira.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {
    fun find(zipCode: String): Address?
}