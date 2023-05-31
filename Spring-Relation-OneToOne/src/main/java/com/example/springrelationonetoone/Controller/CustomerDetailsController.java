package com.example.springrelationonetoone.Controller;

import com.example.springrelationonetoone.DTO.CustomerDetailsDTO;
import com.example.springrelationonetoone.Service.CustomerDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/details")
@RequiredArgsConstructor
public class CustomerDetailsController {
    private final CustomerDetailsService customerDetailsService;
    @PostMapping("add")
    public ResponseEntity addDetailsCustomer(@ResponseBody @Valid CustomerDetailsDTO dto){
        customerDetailsService.addDetails(dto);
        return ResponseEntity.status(200).body("Details aded to customer");
    }
}
