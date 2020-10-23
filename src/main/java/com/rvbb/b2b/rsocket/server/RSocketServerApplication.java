package com.rvbb.b2b.rsocket.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RSocketServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RSocketServerApplication.class, args);
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
