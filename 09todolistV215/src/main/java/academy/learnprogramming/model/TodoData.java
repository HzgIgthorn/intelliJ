package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    //== fields ==
    private static int idvalue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    //== constructors==
    public TodoData() {
        // add some dummy date, user the addItem method so it sets the id field
        addItem(new TodoItem("first","first details", LocalDate.now()));
        addItem(new TodoItem("second","second details", LocalDate.now()));
        addItem(new TodoItem("third","third details", LocalDate.now()));
        addItem(new TodoItem("fourth","fourth details", LocalDate.now()));
    }

    //== public methods==
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd){
        toAdd.setId(idvalue++);
        items.add(toAdd);
    }

    public void removeItem(int id){
        ListIterator<TodoItem> iter = items.listIterator();
        while(iter.hasNext()){
            TodoItem item = iter.next();
            if(item.getId() == id){
                iter.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for (TodoItem item : items){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> iter = items.listIterator();
        while (iter.hasNext()){
            TodoItem item = iter.next();
            if(item.equals(toUpdate)){
                iter.set(toUpdate);
                break;
            }
        }
    }
}
