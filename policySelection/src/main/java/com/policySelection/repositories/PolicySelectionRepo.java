package com.policySelection.repositories;

import com.policySelection.entities.PolicySelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicySelectionRepo extends JpaRepository<PolicySelection,String> {
}
