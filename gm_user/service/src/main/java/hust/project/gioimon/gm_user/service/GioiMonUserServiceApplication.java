package hust.project.gioimon.gm_user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

@EnableDiscoveryClient
@SpringBootApplication
public class GioiMonUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GioiMonUserServiceApplication.class, args);
    }
}
