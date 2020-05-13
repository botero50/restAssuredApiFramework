package com.ab.apitest.DTOs.user;

import lombok.Data;

@Data
public class CreateUserDTO {
    public String first_name;
    public String last_name;
    public String gender;
    public String email;
    public String status;
}
