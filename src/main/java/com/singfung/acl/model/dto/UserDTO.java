package com.singfung.acl.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO
{
    @NotBlank(message = "appId cannot be empty")
    String appId;

    @NotBlank(message = "apiKey cannot be empty")
    String apiKey;
}