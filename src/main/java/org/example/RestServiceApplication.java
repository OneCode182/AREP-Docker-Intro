package org.example;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

    private static final int DEFAULT_PORT = 5000;
    private static final int MIN_PORT = 1;
    private static final int MAX_PORT = 65535;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RestServiceApplication.class);
        application.setDefaultProperties(Map.of("server.port", String.valueOf(getPort())));
        application.run(args);
    }

    public static int getPort() {
        return parsePort(System.getenv("PORT"));
    }

    static int parsePort(String envPort) {
        if (envPort == null || envPort.isBlank()) {
            return DEFAULT_PORT;
        }

        try {
            int parsedPort = Integer.parseInt(envPort.trim());
            if (parsedPort < MIN_PORT || parsedPort > MAX_PORT) {
                return DEFAULT_PORT;
            }
            return parsedPort;
        } catch (NumberFormatException exception) {
            return DEFAULT_PORT;
        }
    }
}
