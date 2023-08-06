package com.policySelection.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PolicySelection {
    @Id
    private String policySelectionId;
    private String pId;
    private String customerName;
    private String customerEmail;
    private String age;
    private String gender;

    //userdetail
}
