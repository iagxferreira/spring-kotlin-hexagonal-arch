package com.iagxferreira.hexagonal.application.ports.out

interface DeleteCustomerByIdOutputPort {
    fun delete(id: String)
}