package com.polarbookshop.orderservice.event;

import com.polarbookshop.orderservice.domain.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
public class OrderFunctions {
    private static final Logger log = LoggerFactory.getLogger(OrderFunctions.class);

    @Bean
    public Consumer<Flux<OrderDispatchedMessage>> dispatchOder(OrderService orderService) {
        return flux -> orderService.consumeOrderDispatchedEvent(flux)
                .doOnNext(order -> log.info("Order {} dispatched", order.id()))
                .subscribe();
}
