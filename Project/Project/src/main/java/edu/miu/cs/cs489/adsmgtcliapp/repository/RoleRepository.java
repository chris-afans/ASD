package edu.miu.cs.cs489.adsmgtcliapp.repository;

import edu.miu.cs.cs489.adsmgtcliapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
