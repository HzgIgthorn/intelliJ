package academy.learnprogramming;

import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context of container
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        //close context of container
        context.close();
    }
}
