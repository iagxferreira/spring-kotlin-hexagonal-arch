package com.iagxferreira.hexagonal.application.ports.out

import com.iagxferreira.hexagonal.application.core.domain.Customer
import java.util.*

interface FindCustomerByIdOutputPort {
    fun find(id: String): Customer?
}