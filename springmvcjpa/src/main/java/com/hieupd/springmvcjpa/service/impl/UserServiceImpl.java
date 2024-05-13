package com.hieupd.springmvcjpa.service.impl;

import com.hieupd.springmvcjpa.dto.RegistrationDto;
import com.hieupd.springmvcjpa.models.Role;
import com.hieupd.springmvcjpa.models.UserEntity;
import com.hieupd.springmvcjpa.repository.RoleRepository;
import com.hieupd.springmvcjpa.repository.UserRepository;
import com.hieupd.springmvcjpa.service.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUserName(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
