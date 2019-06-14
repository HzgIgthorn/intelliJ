package academy.learnprogramming.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Getter
@Service
public class DemoService implements ServiceInterface {

    private String welcomeMessage = "Willkommen in dieser Demo App.";

    @Override
    public String getHelloMessage(String name) {
        return "Hallo "+ name;
    }
}
