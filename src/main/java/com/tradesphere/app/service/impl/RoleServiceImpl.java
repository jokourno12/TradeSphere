package com.tradesphere.app.service.impl;

import com.tradesphere.app.constant.ERole;
import com.tradesphere.app.model.entity.Role;
import com.tradesphere.app.repository.RoleRepository;
import com.tradesphere.app.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role getOrSave(ERole role) {
        Optional<Role> optionalRole = roleRepository.findByRole(role);
        if(optionalRole.isPresent()){
            return optionalRole.get();
        }

        Role currentRole = Role.builder()
                .roleName(role)
                .build();

        return roleRepository.saveAndFlush(currentRole);
    }
}
