package com.iagxferreira.hexagonal.adapters.config.customer

import com.iagxferreira.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.iagxferreira.hexagonal.adapters.out.InsertCustomerAdapter
import com.iagxferreira.hexagonal.application.core.usecase.customer.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {
    @Bean
    fun insertCustomerUseCase(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter
    ):InsertCustomerUseCase {
        return InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter)
    }
}