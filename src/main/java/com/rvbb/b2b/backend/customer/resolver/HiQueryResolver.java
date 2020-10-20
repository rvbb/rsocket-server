package com.rvbb.b2b.backend.customer.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class HiQueryResolver implements GraphQLQueryResolver {

    public String hello(final Optional<String> who) {
        return String.format("Hello, %s!", who.orElse("GraphQL"));
    }

}
