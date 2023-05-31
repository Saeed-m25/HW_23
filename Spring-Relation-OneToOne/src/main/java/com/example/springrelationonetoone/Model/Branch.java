package com.example.springrelationonetoone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numper;
    private String area;


    @ManyToOne
    @JoinColumn(name = "merchant_id",referencedColumnName = "id")
    @JsonIgnore
    private Merchant merchant;
}
