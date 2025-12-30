package org.web.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author czq
 * @date 2024/4/26 10:32
 * @Description:
 */
@Component
public class MyFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        String key = request.getHeaders().getFirst("key");
        if ("1".equals(key)) {
            return chain.filter(exchange);
        }
        exchange.getResponse().setRawStatusCode(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());
        return  exchange.getResponse().setComplete();
    }
}
