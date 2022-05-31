package com.webservices.oms.ordermanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {
    private int id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bornAt;
    private String email;
    private String password;
}
