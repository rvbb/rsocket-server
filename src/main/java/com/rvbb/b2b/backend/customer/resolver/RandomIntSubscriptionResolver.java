package com.rvbb.b2b.backend.customer.resolver;

import com.rvbb.b2b.backend.customer.dto.response.NewsFeed;
import com.rvbb.b2b.backend.customer.util.SMFLogger;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class RandomIntSubscriptionResolver implements GraphQLSubscriptionResolver {

    @SMFLogger
    public Publisher<Integer> randomInt() throws ExecutionException, InterruptedException {
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        ScheduledFuture<Integer> future = scheduler.schedule(new Callable<Integer>() {
//            public Integer call() {
//                return new Random().nextInt();
//            }}, 2, TimeUnit.SECONDS);

        return Flux.interval(Duration.ofSeconds(2)).map(num -> new Random().nextInt());
    }

    public Publisher<NewsFeed> newsFeedSubscribe() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(num -> NewsFeed.builder().randomId(new Random().nextInt()).createdDate(new Date()).build());
    }
}
