package edu.miu.cs.cs489.adsmgtcliapp.repository;

import edu.miu.cs.cs489.adsmgtcliapp.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
