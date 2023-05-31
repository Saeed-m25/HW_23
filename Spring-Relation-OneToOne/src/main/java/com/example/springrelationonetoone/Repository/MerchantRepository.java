package com.example.springrelationonetoone.Repository;

import com.example.springrelationonetoone.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    Merchant findCustomerById (Integer id);

    Merchant findMerchantById(Integer merchantId);
}

