package academy.learnprogramming.service;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

/**
 * Delegation Pattern!!
 */
@Service
public class TodoItemServiceImpl implements TodoItemService {

    //== fields==
    @Getter
    private final TodoData data = new TodoData();

    //== public methods
    @Override
    public void addItem(TodoItem toAdd) {
        this.data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        this.data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return this.data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        this.data.updateItem(toUpdate);
    }

}
