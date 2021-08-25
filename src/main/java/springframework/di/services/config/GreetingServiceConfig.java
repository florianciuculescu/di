package springframework.di.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springframework.di.services.ConstructorGreetingService;
import springframework.di.services.PropertyInjectedGreetingService;
import springframework.di.services.SetterInjectedGreetingService;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
