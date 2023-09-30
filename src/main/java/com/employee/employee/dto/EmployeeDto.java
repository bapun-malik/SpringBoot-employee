package com.employee.employee.dto;

import java.sql.Date;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "FirstName can't be Empty")
    private String firstname;
    private String lastname;
    @Email(message = "not a valid email address")
    @NotEmpty(message = "Email must be provided")
    private String email;
    @NotEmpty(message = "Date of birth is missing")
    private Date dob;
    private boolean havedl;
}
