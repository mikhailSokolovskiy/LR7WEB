package org.example.lr07_spring;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@SpringBootApplication
public class Lr07SpringApplication {

//    @Profile("dev")
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server h2Server() throws SQLException {
//        return Server.createTcpServer("-tcp","-tcpAllowOthers","-tcpPort","9092");
//    }

    public static void main(String[] args) {
        SpringApplication.run(Lr07SpringApplication.class, args);
    }

}
