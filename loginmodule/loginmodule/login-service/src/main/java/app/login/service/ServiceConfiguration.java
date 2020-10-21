package app.login.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"app.login.service","app.login.service.dao"})
@EntityScan("app.login.service.entity")
public class ServiceConfiguration {
}
