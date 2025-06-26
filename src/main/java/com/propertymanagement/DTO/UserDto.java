package com.propertymanagement.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String ownerName;
    @NotNull(message="email is mandatory")
    @NotEmpty(message="password cannot be empty")
    @Size(min=1,max=50, message="email should be between these limits")
    private String ownerEmail;
    private int phone;
    @NotNull(message="password is mandatory")
    @NotEmpty(message="password cannot be empty")
    @Size(min=1,max=12,message="the password should be within th limits")
    private String password;
}
