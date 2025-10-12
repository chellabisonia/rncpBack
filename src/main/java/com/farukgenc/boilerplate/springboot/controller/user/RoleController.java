package com.farukgenc.boilerplate.springboot.controller.user;

import com.farukgenc.boilerplate.springboot.security.dto.RoleDto;
import com.farukgenc.boilerplate.springboot.security.dto.RoleRequest;
import com.farukgenc.boilerplate.springboot.security.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@Tag(name = "Roles", description = "Operations related to user roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    @Operation(
            summary = "Get all roles",
            description = "Retrieves a list of all roles in the system",
            tags = { "Roles" }
    )
    public ResponseEntity<List<RoleDto>> getAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get role by ID",
            description = "Fetch a specific role using its ID",
            tags = { "Roles" }
    )
    public ResponseEntity<RoleDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping
    @Operation(
            summary = "Create a new role",
            description = "Creates a new role with the given details",
            tags = { "Roles" }
    )
    public ResponseEntity<RoleDto> create(@RequestBody @Valid RoleRequest request) {
        return ResponseEntity.ok(roleService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing role",
            description = "Updates the role identified by the given ID with new values",
            tags = { "Roles" }
    )
    public ResponseEntity<RoleDto> update(@PathVariable Long id, @RequestBody @Valid RoleRequest request) {
        return ResponseEntity.ok(roleService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a role",
            description = "Deletes the role identified by the given ID",
            tags = { "Roles" }
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}