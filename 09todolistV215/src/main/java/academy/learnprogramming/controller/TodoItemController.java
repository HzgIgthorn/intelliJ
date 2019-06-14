package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Slf4j
public class TodoItemController {

    //== fields==
    private final TodoItemService service;

    //== constructors==
    @Autowired
    public TodoItemController(TodoItemService service) {
        this.service = service;
    }

    //== model attributes==
    @ModelAttribute
    public TodoData todoData(){
        return service.getData();
    }

    //==handler methods==
    //http://localhost:8080/09todo-listV215/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    //http://localhost:8080/09todo-listV215/addItem
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model){
        log.info("editing id = {}", id);
        TodoItem item = service.getItem(id);
        if(item==null)
            item = new TodoItem("","", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, item);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem item){
        log.info("todoItem from form = {}", item);
        if(item.getId()==0)
            service.addItem(item);
        else
            service.updateItem(item);

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam("id") int id){
        log.info("todoItem with Id {} will be deleted", id);
        service.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DETAILS)
    public String showDetails(@RequestParam("id") int id, Model model){
        log.info("show the details of Item with Id {}", id);
        model.addAttribute(AttributeNames.TODO_ITEM, service.getItem(id));
        return ViewNames.DETAILS;
    }

}
