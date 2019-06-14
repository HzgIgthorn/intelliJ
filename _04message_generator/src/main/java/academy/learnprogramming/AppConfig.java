package academy.learnprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Conf
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {

    //==bean Methods==
    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImp();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }
}
