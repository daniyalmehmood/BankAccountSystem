package com.example.BankSystem.Controller;

import com.example.BankSystem.Model.Customer;
import com.example.BankSystem.RequestObject.UpdateCustomerInfo;
import com.example.BankSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @RequestMapping(value = "addCustomer", method = RequestMethod.POST)
    public String addCustomer(@RequestBody Customer customer) {
        try {
            customerService.addCustomer(customer);
            return "Customer added Successfully";
        } catch (Exception e) {
            return "Customer added Failed";
        }
    }

    @RequestMapping(value = "updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@RequestBody UpdateCustomerInfo updateCustomerInfo) {
        try {
            customerService.updateCustomer(updateCustomerInfo);
            return "Customer Updated Successfully";
        } catch (Exception e) {
            return "Customer Updated Failed";
        }
    }

    @RequestMapping(value = "getCustomer", method = RequestMethod.GET)
    public List<Customer> getCustomer() {
        List<Customer> customers = customerService.getCustomerInfo();
        return customers;
    }

    @RequestMapping(value = "deleteCustomer", method = RequestMethod.POST)
    public String deleteCustomer(@RequestParam Integer id) {
        try {
            customerService.deleteCustomer(id);
            return "Customer Updated Successfully";
        } catch (Exception e) {
            return "Customer Updated Failed";
        }
    }




}
