package springframework.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springframework.di.controllers.MyController;

@SpringBootApplication
public class DiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiApplication.class, args);

        // spring context gaseste bean-urile dupa numele clasei (cu litera mica)
        MyController myController = (MyController) context.getBean("myController");

        String greeting = myController.sayHello();

        System.out.println(greeting);
    }

}
