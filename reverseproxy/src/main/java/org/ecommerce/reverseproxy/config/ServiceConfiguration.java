package org.ecommerce.reverseproxy.config;


import com.netflix.discovery.DiscoveryClient;
import org.ecommerce.reverseproxy.ReverseProxyApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableDiscoveryClient
public class ServiceConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceConfiguration.class);

//    @Bean
//    public DiscoveryClientRouteDefinitionLocator
//    discoveryClientRouteLocator(DiscoveryClient discoveryClient) {
//
//        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
//    }

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://httpbin.org:80"))
//                .build();
//    }

//    @Bean
//    public DiscoveryClientRouteDefinitionLocator
//    discoveryClientRouteLocator(DiscoveryClient discoveryClient) {
//
//        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
//    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        LOGGER.atInfo().log("configure customRouteLocator");
//        return builder.routes()
//                .route("path_route", r -> r.path("/get")
//                        .uri("http://httpbin.org"))
//                .route("host_route", r -> r.host("*.myhost.org")
//                        .uri("http://httpbin.org"))
//                .route("rewrite_route", r -> r.host("*.rewrite.org")
//                        .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
//                        .uri("http://httpbin.org"))
////                .route("hystrix_route", r -> r.host("*.hystrix.org")
////                        .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
////                        .uri("http://httpbin.org"))
////                .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
////                        .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
////                        .uri("http://httpbin.org"))
////                .route("limit_route", r -> r
////                        .host("*.limited.org").and().path("/anything/**")
////                        .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
////                        .uri("http://httpbin.org"))
//                .route("path_route_ui", r -> r.path("/ui/**")
//                        .filters(f -> f.rewritePath("/ui/(?<segment>.*)", "/${segment}"))
//                        //.uri("http://ui"))
//                        .uri("lb://ui"))
////                        .uri("http://localhost:56940"))
////                .route("path_route_ui2", r -> r.path("/ui/product2.html")
////                        .uri("http://localhost:51015/product2.html"))
//                .route("path_route_ui", r -> r.path("/ui2")
//                        .uri("http://ui"))
//                .build();
//    }
}
