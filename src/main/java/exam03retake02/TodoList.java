package exam03retake02;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
//
//    private List<Todo> todos = new ArrayList<>();
//
//
//
//    public TodoList() {
//    }
//
//    public List<Todo> getTodos() {
//        return todos;
//    }
//
//    public int getNumberOfItemsLeft() {
//        List<Todo> result = new ArrayList<>();
//
//        for (Todo t : todos) {
//            if (t.getState().equals(State.NON_COMPLETED)) {
//                result.add(t);
//            }
//        }
//        return result.size();
//    }
//
//    public void addTodo(Todo added) {
//        todos.add(added);
//    }
//
//    public List<String> getMostImportantTodosText(){
//
//        List<String> result = new ArrayList<>();
//        int pr = 5;
//        for (Todo t : todos) {
//            if (t.getPriority()<pr) {
//                pr=t.getPriority();
//            }
//        }
//        for (Todo t : todos) {
//            if (t.getPriority()==pr){
//                result.add(t.getText());
//            }
//        }
//        return result;
//    }
//
//    public void deleteCompleted(){
//
//        for (int i=0; i<todos.size(); i++) {
//            if (todos.get(i).getState().equals(State.COMPLETED)) {
//                todos.remove(i);
//            }
//        }
//    }

    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo t) {
        todos.add(t);
    }

    public List<Todo> getNumberOfItemsLeft() {
        List<Todo> result = new ArrayList<>();
        for (Todo t : todos) {
            if (t.getState().equals(State.NON_COMPLETED)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Todo> getMostImportantTodosText() {
        List<Todo> result = new ArrayList<>();
        int max = 5;
        for (Todo t : todos) {
            if (t.getPriority() < max){
                max = t.getPriority();
            }
        }
        for (Todo t : todos) {
            if (t.getPriority() == max) {
                result.add(t);
            }

        }
        return result;
    }

    public void deleteCompleted(){
        for (Todo t : todos) {
            if (t.getState().equals(State.COMPLETED)) {
               todos.remove(t);
            }
    }
}
}

