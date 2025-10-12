package com.farukgenc.boilerplate.springboot.repository;

import com.farukgenc.boilerplate.springboot.model.user.RolesUsers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolesUsersRepository extends JpaRepository<RolesUsers, Long> {
	

}
