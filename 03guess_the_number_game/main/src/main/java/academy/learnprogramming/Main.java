package academy.learnprogramming;

import academy.learnprogramming.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context of container
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        //call method next() to ger a random number
        int number = numberGenerator.next();

        //log generated number
        log.info("getMainMessage= {}", messageGenerator.getMainMessage());
        log.info("number = {}", number);

        // call reset method (is called by the container as init-method)
        // game.reset();

        //close context of container
        log.info("getMainMessage= {}", messageGenerator.getResultMessage());
        context.close();
    }
}
