package app.login.api.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("app.login.api.controller")
@ServletComponentScan("app.login.api.filters")
public class WebConfig {
}
