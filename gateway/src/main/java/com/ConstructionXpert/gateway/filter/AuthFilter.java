package com.ConstructionXpert.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private RouteValidator validator;

    @Autowired
    private RestTemplate template;

    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (validator.isSecred.test(exchange.getRequest())) {
                //Header token ou pas
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Missing Auth Header");
                }
                String AuthHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(AuthHeader!=null && AuthHeader.startsWith("Bearer")){
                    AuthHeader = AuthHeader.substring(7);
                }
                try{
                    System.out.println(AuthHeader);
                    template.getForObject("http://localhost:8200/Auth/validate?token="+ AuthHeader, String.class);
                }catch (Exception e){
                    throw new RuntimeException("Auth missing");
                }
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            }));
        };
    }


    public static class Config {
    }
}
