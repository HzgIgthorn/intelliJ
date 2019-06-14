package academy.learnprogramming;

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

        //call method next() to ger a random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}", number);

        // get game bean from context of container
        Game game = context.getBean(Game.class);

        // call reset method (is called by the container as init-method)
        // game.reset();

        //close context of container
        context.close();
    }
}
