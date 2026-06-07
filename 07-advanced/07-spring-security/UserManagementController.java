package com.example.secureapi.controller;

import com.example.secureapi.dto.UserDto;
import com.example.secureapi.entity.User;
import com.example.secureapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class UserManagementController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('USER_READ')")
    @PostFilter("hasRole('SUPER_ADMIN') or filterObject.username != 'admin'")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PostAuthorize("hasRole('SUPER_ADMIN') or returnObject.id == authentication.principal.id")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_WRITE') and (#id == authentication.principal.id or hasRole('ADMIN'))")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_DELETE') and hasRole('SUPER_ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{id}/roles")
    @PreAuthorize("hasAuthority('ROLE_WRITE') and hasRole('SUPER_ADMIN')")
    public UserDto assignRole(@PathVariable Long id, @RequestBody String roleName) {
        return userService.assignRole(id, roleName);
    }

    @GetMapping("/search")
    @PreAuthor("hasPermission(#username, 'User', 'READ')")
    public UserDto searchUser(@RequestParam String username) {
        return userService.findByUsername(username);
    }
}
