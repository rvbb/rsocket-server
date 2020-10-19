package com.rvbb.b2b.backend.customer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*example about response to client - it differences entity and dto*/
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomizedCustomerResponse {
    private String customerName;
    private String mobilePhone;
    private int yearOld;
}
