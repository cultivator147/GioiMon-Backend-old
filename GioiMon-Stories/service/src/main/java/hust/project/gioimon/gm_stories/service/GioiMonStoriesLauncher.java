package hust.project.gioimon.gm_stories.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GioiMonStoriesLauncher {
    public static void main(String[] args) {
        SpringApplication.run(GioiMonStoriesLauncher.class, args);
    }
}