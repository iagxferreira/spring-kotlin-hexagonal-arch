package com.iagxferreira.hexagonal.adapters.config.customer

import com.iagxferreira.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.iagxferreira.hexagonal.application.core.usecase.customer.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerConfig {

    @Bean
    fun findCustomerByIdUseCase(
        findCustomerByIdAdapter: FindCustomerByIdAdapter,
    ): FindCustomerByIdUseCase {
        return FindCustomerByIdUseCase(findCustomerByIdAdapter)
    }
}