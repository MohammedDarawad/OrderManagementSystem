package com.webservices.oms.ordermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private Date bornAt;
}
