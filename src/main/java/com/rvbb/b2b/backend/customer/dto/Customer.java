package com.rvbb.b2b.backend.customer.dto;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private String phone;
    private int age;
}
