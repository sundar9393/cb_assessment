package app.login.api;

import app.login.service.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServiceConfiguration.class)
public class LoginApp {
    public static void main(String[] args) {
        SpringApplication.run(LoginApp.class, args);
    }
}
