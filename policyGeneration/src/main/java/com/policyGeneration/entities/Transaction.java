package com.policyGeneration.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    private String transactionId;
    private boolean status;
    private String policySelectionId;

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", status=" + status +
                ", policySelectionId='" + policySelectionId + '\'' +
                '}';
    }
}
