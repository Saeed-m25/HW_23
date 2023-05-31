package com.example.springrelationonetoone.Service;

import com.example.springrelationonetoone.ApiExeception.ApiExeception;
import com.example.springrelationonetoone.Model.Branch;
import com.example.springrelationonetoone.Model.Merchant;
import com.example.springrelationonetoone.Repository.BranchRepository;
import com.example.springrelationonetoone.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;
    private final MerchantRepository merchantRepository;

    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    public void updateBranch(Branch branch, Integer id) {
        Branch oldBranch = branchRepository.findBranchById(id);
        if (oldBranch == null) {
            throw new ApiExeception("branch not found");
            oldBranch.setArea(branch.getArea());
            oldBranch.setNumper(branch.getNumper());

        }


        public void deleteBranch (Integer id){
            Branch branch = branchRepository.findBranchById(id);
            if (branch == null) {
                throw new ApiExeception("customer not found");
            }

            branchRepository.delete(branch);
        }
        

    }
    public void assignMerchantToBarnch(Integer merchant_id, Integer branch_Id){
        Merchant merchant=merchantRepository.findMerchantById(merchant_id);
        Branch branch=branchRepository.findBranchById(branch_Id);
        
        if (merchant==null || branch==null){
            throw new ApiExeception("id wrong , can't assign merchant to branch");
        }
        branch.setMerchant(merchant);
        
        branchRepository.save(branch);
    }

    public void addBranch(Branch branch) {
    }

    public void deleteBranch(Integer id) {
    }
}
