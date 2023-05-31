package com.example.springrelationonetoone.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDetailsDTO {


    private Integer customer_id;
    private String gender;
    private Integer age;
    private String email;
}
