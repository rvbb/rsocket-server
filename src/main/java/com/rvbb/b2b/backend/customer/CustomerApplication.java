package com.rvbb.b2b.backend.customer;

import com.rvbb.b2b.backend.customer.resolver.HiQueryResolver;
import graphql.kickstart.execution.config.DefaultGraphQLSchemaProvider;
import graphql.kickstart.execution.config.GraphQLSchemaProvider;
import graphql.kickstart.servlet.SimpleGraphQLHttpServlet;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.annotation.WebServlet;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

//    @WebServlet(urlPatterns = "/abc")
//    public class GraphQLEndpoint extends SimpleGraphQLHttpServlet {
//        public GraphQLEndpoint() {
//        }
//    }

//    @Bean
//    public GraphQLMutationResolver mutation() {
//        return new GraphQLMutationResolver();
//    }

    /*simple SDL*/
   /* @Bean
    GraphQLSchema schema() {
        return GraphQLSchema.newSchema()
            .query(GraphQLObjectType.newObject()
                .name("query")
                .field(field -> field
                    .name("test")
                    .type(Scalars.GraphQLString)
                    .dataFetcher(environment -> "response")
                )
                .build())
            .build();
    }*/

}
