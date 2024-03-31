package com.tradesphere.app.repository;

import com.tradesphere.app.constant.ERole;
import com.tradesphere.app.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRole(ERole role);
}
