package com.example.springrelationonetoone.Service;

import com.example.springrelationonetoone.ApiExeception.ApiExeception;
import com.example.springrelationonetoone.Model.Customer;
import com.example.springrelationonetoone.Model.Merchant;
import com.example.springrelationonetoone.Repository.MerchantRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final MerchantRepository merchantRepository;


    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }


    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer, Integer id) {
        Customer oldCustomer = customerRepository.findCustomerById(id);
        if (oldCustomer == null) {
            throw new ApiException("customer not found");
        }

        oldCustomer.setName(customer.getName());
        customerRepository.save(oldCustomer);
    }


    public void deleteCustomer(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null) {
            throw new ApiExeception("customer not found");
        }

        customerRepository.delete(customer);
    }

    public List<Customer> getAllCustomers() {
    }

    public void  assingnCustomerToMerchant(Integer merchant,Integer customer_id)
    {

        Merchant merchant=merchantRepository.findMerchantById(merchant_id);
        Customer customer=customerRepository.findCustomerById(customer_id);
        if (merchant==null||customer==null){
            throw new ApiExeception("Data Wrong");
        }
        merchant.getCustomers().add(customer);
        customer.getMerchants().add(merchant);

        merchantRepository.save(merchant);
        customerRepository.save(customer);

}
}

