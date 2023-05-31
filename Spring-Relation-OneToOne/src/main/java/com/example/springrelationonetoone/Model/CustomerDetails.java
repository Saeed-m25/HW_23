package com.example.springrelationonetoone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetails {

    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(10)not null")
    private String gender;
    @Column(columnDefinition = "int default 0")
    private Integer age;
    @Column(columnDefinition = "varchar(20)not null")
    private String email;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;
}
