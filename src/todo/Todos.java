package todo;

import java.util.ArrayList;
import java.util.List;

public class Todos {
  private static List<Todo> todos;

  public Todos(){
    this.todos = new ArrayList<>();
  }

  public void add(Todo todo) {
    todos.add(todo);
  }

  public void remove(Todo todo) {
    todos.remove(todo);
  }

  public static List<Todo> getTodos() {
    return todos;
  }

  @Override
  public String toString(){
    String result = "";
    for (int i = 0; i < todos.size(); i++) {
      result += (i + 1) + ". " + todos.get(i) + "\n";
    }
    return result;
  }

  public String list(){
    String result = "";
    for (int i = 0; i < todos.size(); i++) {
      result += (i + 1) + ". " + todos.get(i).getName() + "\n";
    }
    return result;
  }
}