package springframework.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springframework.di.controllers.ConstructorInjectedController;
import springframework.di.controllers.I18nController;
import springframework.di.controllers.MyController;
import springframework.di.controllers.PetController;
import springframework.di.controllers.PropertyInjectedController;
import springframework.di.controllers.SetterInjectedController;
import springframework.di.services.PrototypeBean;
import springframework.di.services.SingletonBean;

@SpringBootApplication
public class DiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiApplication.class, args);

        PetController petController = context.getBean("petController", PetController.class);
        System.out.println("The best pet is: ");
        System.out.println(petController.whichPetIsTheBest());

        I18nController i18nController = (I18nController) context.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        // spring context gaseste bean-urile dupa numele clasei (cu litera mica)
        MyController myController = (MyController) context.getBean("myController");
        System.out.println("------------- Primary Bean");
        System.out.println(myController.sayHello());

        System.out.println("------------- Property");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");

        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("------------- Setter");

        SetterInjectedController setterInjectedController = (SetterInjectedController) context.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());


        System.out.println("------------- Constructor");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("----- Bean Scopes ----------");

        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        System.out.println(singletonBean2.getMyScope());

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean2.getMyScope());
    }

}
