package com.singfung.acl.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO
{
    @NotBlank(message = "username cannot be empty")
    String username;

    @NotBlank(message = "password cannot be empty")
    String password;
}