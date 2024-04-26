package com.iagxferreira.hexagonal.adapters.out.repository

import com.iagxferreira.hexagonal.adapters.out.repository.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository: MongoRepository<CustomerEntity, String> {
}