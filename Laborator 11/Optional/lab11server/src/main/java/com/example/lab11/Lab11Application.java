package com.example.lab11;

import com.example.lab11.server.SocialServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@SpringBootApplication
public class Lab11Application {

    public static void main(String[] args) throws IOException {
        SocialServer socialServer = new SocialServer();
        SpringApplication.run(Lab11Application.class, args);
    }

}
