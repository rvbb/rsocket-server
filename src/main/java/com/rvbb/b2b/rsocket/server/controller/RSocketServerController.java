package com.rvbb.b2b.rsocket.server.controller;

import com.rvbb.b2b.rsocket.server.dto.Customer;
import com.rvbb.b2b.rsocket.server.dto.response.NewsFeed;
import com.rvbb.b2b.rsocket.server.entity.CustomerEntity;
import com.rvbb.b2b.rsocket.server.repository.ICustomerRepository;
import com.rvbb.b2b.rsocket.server.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

@Slf4j
@Controller
public class RSocketServerController {

    @Autowired
    private CustomerService service;

    /*Request & Response*/
    @MessageMapping("getCustomer")
    public Mono<CustomerEntity> currentMarketData(Long id) {
        CustomerEntity customerEntity =  service.getCustomerById(id);
        return Mono.just(customerEntity);
    }

    /*Fire then Forget*/
    @MessageMapping("addCustomer")
    public Mono<Void> addOneCustomer(Customer dto) {
        CustomerEntity createdCustomer =  service.insert(dto);
        log.info("createdCustomer={}", createdCustomer);
        return Mono.empty();
    }

    /*stream*/
    @MessageMapping("feedCustomer")
    public Flux<CustomerEntity> feedCustomer(Long id) {
        CustomerEntity customerEntity =  service.getCustomerById(id);
        return Flux.just(customerEntity);
    }

    @MessageMapping("newFeed")
    public Flux<NewsFeed> feedCustomer() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(num -> NewsFeed.builder().randomId(new Random().nextInt()).createdDate(new Date()).build());
    }
}
