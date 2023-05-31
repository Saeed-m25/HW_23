package com.example.springrelationonetoone.Controller;

import com.example.springrelationonetoone.ApiResponse.ApiResponse;
import com.example.springrelationonetoone.Model.Customer;
import com.example.springrelationonetoone.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/Customer")
@RequiredArgsConstructor
@Service
public class CustomerCotroller {

    private final CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity getAllCustomers(){
        List<Customer> customerList=customerService.getAllCustomers();
        return ResponseEntity.status(200).body(customerList);
    }


    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("customer added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@Valid @RequestBody Customer customer, @PathVariable Integer id){
        customerService.updateCustomer(customer,id);
        return ResponseEntity.status(200).body("customer Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("customer deleted");


    }
    @PutMapping("/{merchant_id}/asssing/{customer_id}")
    public ResponseEntity assignCustomerToMerchant(@PathVariable Integer merchant_id,Integer customer_id ){
        customerService.assingnCustomerToMerchant(merchant_id,customer_id);
        return ResponseEntity.status(200).body("assign Done");
    }

}
