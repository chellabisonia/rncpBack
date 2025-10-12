package com.farukgenc.boilerplate.springboot.security.service;

import com.farukgenc.boilerplate.springboot.model.user.Role;
import com.farukgenc.boilerplate.springboot.repository.RoleRepository;
import com.farukgenc.boilerplate.springboot.security.dto.RoleDto;
import com.farukgenc.boilerplate.springboot.security.dto.RoleRequest;
import com.farukgenc.boilerplate.springboot.security.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
    }

    public RoleDto findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return roleMapper.toDto(role);
    }

    public RoleDto create(RoleRequest request) {
        Role role = roleMapper.toEntity(request);
        return roleMapper.toDto(roleRepository.save(role));
    }

    public RoleDto update(Long id, RoleRequest request) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        existing.setUserRole(request.getUserRole());
        return roleMapper.toDto(roleRepository.save(existing));
    }

    public void delete(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found");
        }
        roleRepository.deleteById(id);
    }
}
