//package hust.project.gioimon.gm_gateway.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableHystrix
//public class GatewayConfig {
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("user-service", r -> r.path("/users/**")
//                        .uri("lb://user-service"))
//
//                .route("auth-service", r -> r.path("/auth/**")
//                        .uri("lb://auth-service"))
//                .build();
//    }
//}
