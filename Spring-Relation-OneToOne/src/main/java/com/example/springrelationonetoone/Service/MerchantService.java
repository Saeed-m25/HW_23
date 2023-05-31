package com.example.springrelationonetoone.Service;

import com.example.springrelationonetoone.ApiExeception.ApiExeception;
import com.example.springrelationonetoone.Model.Customer;
import com.example.springrelationonetoone.Model.Merchant;
import com.example.springrelationonetoone.Repository.MerchantRepository;
import org.hibernate.mapping.List;

public class MerchantService {
    private final MerchantRepository merchantRepository;

    public List<Merchant> getAllMerchant(){
        return merchantRepository.findAll();
    }


    public void addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
    }

    public void updateMerchant(Merchant merchant,Integer id){
        Merchant oldMerchant= merchantRepository.findMerchantById(id);
        if(oldMerchant==null){
            throw new ApiExeception("Merchant not found");
        }

        oldMerchant.setName(merchant.getName());
        merchantRepository.save(oldMerchant);
    }


    public void deleteMerchant(Integer id){
        Merchant merchant= merchantRepository.findMerchantById(id);
        if(merchant==null){
            throw new ApiExeception("Merchant not found");
        }

        merchantRepository.delete(merchant);
    }
 }

