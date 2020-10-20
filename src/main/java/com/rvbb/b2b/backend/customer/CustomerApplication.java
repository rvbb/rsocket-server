package com.rvbb.b2b.backend.customer;

import com.rvbb.b2b.backend.customer.service.CustomerService;
import com.rvbb.b2b.backend.customer.service.OrderService;
import graphql.kickstart.tools.SchemaParser;
import graphql.kickstart.tools.SchemaParserOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
    /*simple SDL*/
//    @Bean
//    GraphQLSchema schema() {
//        return GraphQLSchema.newSchema()
//            .query(GraphQLObjectType.newObject()
//                .name("query")
//                .field(field -> field
//                    .name("test")
//                    .type(Scalars.GraphQLString)
//                    .dataFetcher(environment -> "response")
//                )
//                .build())
//            .build();
//    }

}
