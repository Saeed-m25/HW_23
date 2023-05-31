package com.example.springrelationonetoone.Controller;

import com.example.springrelationonetoone.ApiResponse.ApiResponse;
import com.example.springrelationonetoone.DTO.CustomerDetailsDTO;
import com.example.springrelationonetoone.Model.Branch;
import com.example.springrelationonetoone.Model.Merchant;
import com.example.springrelationonetoone.Service.BranchService;
import com.example.springrelationonetoone.Service.CustomerDetailsService;
import com.example.springrelationonetoone.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/branch")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;


    @GetMapping("/get")
    public ResponseEntity getAllBranch(){
        List<Branch> branchList=branchService.getAllBranch();
        return ResponseEntity.status(200).body(branchList);
    }


    @PostMapping("/add")
    public ResponseEntity addBranch(@Valid @RequestBody Branch branch){
        branchService.addBranch(branch);
        return ResponseEntity.status(200).body(new ApiResponse("Branch added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBranch(@Valid @RequestBody Branch branch, @PathVariable Integer id){
        branchService.updateBranch(branch,id);
        return ResponseEntity.status(200).body("Branch Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBranch(@PathVariable Integer id){
        branchService.deleteBranch(id);
        return ResponseEntity.status(200).body("customer deleted");



    }


}
//}
//
//
//
//private final BranchService branchService;
//@PostMapping("add")
//public  ResponseEntity addBranch(@ResponseBody @Valid BranchDTO dto){
//        branchService.addBranch(dto);
//        return ResponseEntity.status(200).body("Details aded to Branch");
//        }
//
