package com.farukgenc.boilerplate.springboot.repository;

import com.farukgenc.boilerplate.springboot.model.enumeration.UserRole;
import com.farukgenc.boilerplate.springboot.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {


    Optional<Role> findByUserRole(UserRole userRole);
}
