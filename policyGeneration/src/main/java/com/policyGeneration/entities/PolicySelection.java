package com.policyGeneration.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PolicySelection {
    private String policySelectionId;
    private String pId;
    private String customerName;
    private String customerEmail;
    private String age;
    private String gender;

    //userdetail
}
