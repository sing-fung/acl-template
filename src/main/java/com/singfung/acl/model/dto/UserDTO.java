package com.singfung.acl.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO
{
    @NotBlank(message = "username cannot be empty")
    String username;

    @NotBlank(message = "password cannot be empty")
    String password;
}