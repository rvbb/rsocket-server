package com.rvbb.b2b.backend.customer.dto.response;

import com.rvbb.b2b.backend.customer.dto.Customer;
import com.rvbb.b2b.backend.customer.entity.CustomerEntity;
import lombok.*;

/*example about response to client - it differences entity and dto*/
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomizedCustomerResponse {
    private String customerName;
    private String mobilePhone;
    private int yearOld;
    private Long id;

    public static CustomizedCustomerResponse of(CustomerEntity entity){
        return CustomizedCustomerResponse.builder()
                .customerName(entity.getName())
                .mobilePhone(entity.getPhone())
                .yearOld(entity.getAge())
                .id(entity.getId())
                .build();
    }
}
