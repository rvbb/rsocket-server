package com.rvbb.b2b.backend.customer.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/*use GraphQLResolver for any extension fields*/
@Slf4j
//@Component
public class CustomerExtensionFieldsResolver /*implements GraphQLResolver<CustomerEntity> */{

    public String extensionFieldNeedToResolve() {
        return "";
    }
}
