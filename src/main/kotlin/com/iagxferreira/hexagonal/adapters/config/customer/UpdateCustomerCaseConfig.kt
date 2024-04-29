package com.iagxferreira.hexagonal.adapters.config.customer

import com.iagxferreira.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.iagxferreira.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.iagxferreira.hexagonal.adapters.out.UpdateCustomerAdapter
import com.iagxferreira.hexagonal.application.core.usecase.customer.UpdateCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerCaseConfig {
    @Bean
    fun updateCustomerByIdUseCase(
        findCustomerByIdAdapter: FindCustomerByIdAdapter,
        findAddressByIdAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
    ): UpdateCustomerByIdUseCase{
        return UpdateCustomerByIdUseCase(findCustomerByIdAdapter, findAddressByIdAdapter, updateCustomerAdapter)
    }
}