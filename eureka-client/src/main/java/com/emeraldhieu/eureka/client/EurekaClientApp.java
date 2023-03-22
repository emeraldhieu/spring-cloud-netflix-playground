package com.emeraldhieu.eureka.client;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EurekaClientApp implements GreetingController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EurekaClientApp.class);

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApp.class, args);
    }

    /**
     * Get dynamic port.
     * See https://www.baeldung.com/spring-boot-running-port#2-handling-servletwebserverinitializedevent
     */
    @EventListener
    public void onApplicationEvent(final ServletWebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
        log.info("Server's port is: " + port);
    }

    @Override
    public String greeting() {
        return String.format(
          "Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }
}