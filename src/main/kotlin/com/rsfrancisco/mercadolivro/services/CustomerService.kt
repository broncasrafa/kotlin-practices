package com.rsfrancisco.mercadolivro.services

import com.rsfrancisco.mercadolivro.classes.extensions.toCustomerEntity
import com.rsfrancisco.mercadolivro.classes.extensions.toCustomerModel
import com.rsfrancisco.mercadolivro.classes.models.CustomerModel
import com.rsfrancisco.mercadolivro.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(val repository: CustomerRepository) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return repository.findByNameContainingIgnoreCase(name).map { it.toCustomerModel() }
        }
        return repository.findAll().map{ it.toCustomerModel() }
        
//        return if (name.isNullOrBlank()) {
//            repository.findAll().map{ it.toCustomerModel() }
//        } else {
//            repository.findByNameContainingIgnoreCase(name).map { it.toCustomerModel() }
//        }
    }

    fun getById(id: Int): CustomerModel? {
        var customer = repository.findById(id).orElseThrow()
            //?: throw Exception("Customer with ID: '${id}' was not found")
        return customer.toCustomerModel()
    }

    fun insertOne(model: CustomerModel): CustomerModel {
        val customer = model.toCustomerEntity()
        val newCustomer = repository.save(customer)
        return newCustomer.toCustomerModel()
    }

    fun updateOne(model: CustomerModel, id: Int) {
        var customCustomer = repository.findById(id).orElseThrow()
            //?: throw Exception("Customer with ID: '${id}' was not found")
        customCustomer.let {
            it.name = model.name
            it.email = model.email
        }
        repository.save(customCustomer);
    }

    fun deleteOne(id: Int) {
        var customCustomer = repository.findById(id) ?: throw Exception("Customer with ID: '${id}' was not found")
        repository.delete(customCustomer.get())
    }
}