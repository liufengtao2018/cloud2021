package com.gtcom.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: morning
 * @createDate: 2021/2/7 16:33
 * @version:
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("gateway-guonei", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route("gateway-guoji", r -> r.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }
}
