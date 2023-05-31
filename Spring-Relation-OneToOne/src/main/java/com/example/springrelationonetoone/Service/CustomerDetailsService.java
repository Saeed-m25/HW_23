package com.example.springrelationonetoone.Service;

import com.example.springrelationonetoone.DTO.CustomerDetailsDTO;
import com.example.springrelationonetoone.Model.CustomerDetails;
import com.example.springrelationonetoone.Repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
    private final CustomerDetailsRepository customerDetailsRepository;

    private final CustomerRepository customerRepository;
    public void  AddDetails(CustomerDetailsDTO dto){
        Customer customer=customerRepository.findCustomerById(dto.getCustomer_id());

        if (customer==null){
            throw new ApiException("cin't add details, customer not found");

        }
        CustomerDetails customerDetails=new CustomerDetails( null,dto.getGender(),dto.getAge(),dto.getEmail(),customer)
        customerDetailsRepository.save(customerDetails);
    }

}
