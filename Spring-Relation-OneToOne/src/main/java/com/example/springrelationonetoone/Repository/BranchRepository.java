package com.example.springrelationonetoone.Repository;

import com.example.springrelationonetoone.Model.Branch;

import java.util.List;

public interface BranchRepository {
    Branch findBranchById(Integer id);

    void save(Branch branch);

    void delete(Branch branch);

    List<Branch> findAll();
}
