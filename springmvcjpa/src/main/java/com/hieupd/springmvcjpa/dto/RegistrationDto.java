package com.hieupd.springmvcjpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegistrationDto {
    private Long id;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    private String email;
}
