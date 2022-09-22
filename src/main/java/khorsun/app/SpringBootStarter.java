package khorsun.app;

import khorsun.app.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(
        scanBasePackages = "khorsun.app")
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(SpringConfig.class)
public class SpringBootStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }
}
