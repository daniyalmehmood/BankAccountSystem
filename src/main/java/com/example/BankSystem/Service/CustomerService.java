package com.example.BankSystem.Service;

import com.example.BankSystem.Model.Customer;
import com.example.BankSystem.Repository.CustomerRepository;
import com.example.BankSystem.RequestObject.UpdateCustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public void addCustomer(Customer customer) {
        Customer customerInfo = new Customer();
        customerInfo.setName(customer.getName());
        customerInfo.setEmail(customer.getEmail());
        customerInfo.setPhone(customer.getPhone());
        customerInfo.setIsActive(customer.getIsActive());
        customerRepository.save(customerInfo);

    }

    public void updateCustomer(UpdateCustomerInfo customer) {
        Customer customerInfo = new Customer();
        customerInfo.setId(customer.getId());
        customerInfo.setName(customer.getName());
        customerInfo.setEmail(customer.getEmail());
        customerInfo.setPhone(customer.getPhone());
        customerInfo.setIsActive(customer.getIsActive());
        customerRepository.save(customerInfo);

    }

    public List<Customer> getCustomerInfo() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }

    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).get();
        customer.setIsActive("false");
        customerRepository.save(customer);
    }
}
