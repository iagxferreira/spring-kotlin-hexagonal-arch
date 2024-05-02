package com.iagxferreira.hexagonal.adapters.config.customer

import com.iagxferreira.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.iagxferreira.hexagonal.application.core.usecase.customer.DeleteCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerCaseConfig {
    @Bean
    fun deleteCustomerByIdUseCase(
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ): DeleteCustomerByIdUseCase {
        return DeleteCustomerByIdUseCase(deleteCustomerByIdAdapter)
    }
}