package edu.miu.cs.cs489.lab7.repository;

import edu.miu.cs.cs489.lab7.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
