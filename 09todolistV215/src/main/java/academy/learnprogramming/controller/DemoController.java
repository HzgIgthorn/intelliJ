package academy.learnprogramming.controller;

import academy.learnprogramming.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    //== fields==
    private final ServiceInterface service;

    //== constructors==
    @Autowired
    public DemoController(ServiceInterface service) {
        this.service = service;
    }

    //== request methods==
    // http://localhost:8080/09todo-listV215/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hallo";
    }

    // http://localhost:8080/09todo-listV215/welcome?user=Max%20Mustermann&age=29
    @GetMapping("/welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("welcomeUser", service.getHelloMessage(user));
        model.addAttribute("age", age);
        log.debug("model = {}", model);

        // prefix + name + suffix
        // /WEB-INF/view/welcome.jsp
        return "welcome";
    }

    //== model attributes==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return service.getWelcomeMessage();
    }
}
