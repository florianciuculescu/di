package springframework.di.services.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import springframework.di.datasource.FakeDataSource;
import springframework.di.repositories.EnglishGreetingRepository;
import springframework.di.repositories.EnglishGreetingRepositoryImpl;
import springframework.di.services.ConstructorGreetingService;
import springframework.di.services.I18nEnglishGreetingService;
import springframework.di.services.I18nSpanishGreetingService;
import springframework.di.services.PrimaryGreetingService;
import springframework.di.services.PropertyInjectedGreetingService;
import springframework.di.services.SetterInjectedGreetingService;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:di-config.xml")
@Configuration
public class GreetingServiceConfig {

    // ${} --> Spring expression language
    @Bean
    FakeDataSource fakeDataSource(@Value("${di.username}") String userName,
                                  @Value("${di.password}") String password,
                                  @Value("${di.jdbcUrl}") String jdbcUrl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(userName);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

//    @Bean
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
