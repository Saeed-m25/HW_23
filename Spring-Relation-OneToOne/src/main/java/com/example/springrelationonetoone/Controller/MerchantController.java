package com.example.springrelationonetoone.Controller;

import com.example.springrelationonetoone.ApiResponse.ApiResponse;
import com.example.springrelationonetoone.Model.Customer;
import com.example.springrelationonetoone.Model.Merchant;
import com.example.springrelationonetoone.Service.CustomerService;
import com.example.springrelationonetoone.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
@Service
public class MerchantController {


    private final MerchantService merchantService;
    @GetMapping("/get")
    public ResponseEntity getAllMerchant(){
        List<Merchant> merchantList=merchantService.getAllMerchant();
        return ResponseEntity.status(200).body(merchantList);
    }


    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant){
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchant, @PathVariable Integer id){
        merchantService.updateMerchant(merchant,id);
        return ResponseEntity.status(200).body("Merchant Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){
        merchantService.deleteMerchant(id);
        return ResponseEntity.status(200).body("customer deleted");



    }


}
