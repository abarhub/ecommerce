package org.ecommerce.reverseproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//@EnableZuulProxy
@EnableDiscoveryClient
public class ReverseProxyApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReverseProxyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReverseProxyApplication.class, args);
	}
}
