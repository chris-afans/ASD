package edu.miu.cs.cs489.lab11.repository;

import edu.miu.cs.cs489.lab11.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
