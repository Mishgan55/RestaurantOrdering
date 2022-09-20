package khorsun.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SpringConfig.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("khorsun.app")
public class ApplicationContextStarter {
}
