import org.junit.Test;
import todo.Todo;
import todo.Todos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoAppTest {

  TodoApp myTodoApp = new TodoApp();

  @Test
  public void testAddTodo() {
    Todos myTodoList = new Todos();
    myTodoList.add(new Todo("Clean the room", false));
    String name = myTodoList.getTodos().get(0).getName();
    assertEquals("Clean the room", name);
  }

  @Test
  public void testProcessDataName() {
    List<String> todoList = new ArrayList<>(Arrays.asList("Clean the room;1"));
    Todos myTodo = myTodoApp.processData(todoList);
    assertEquals("Clean the room", myTodo.getTodos().get(0).getName());
  }

  @Test
  public void testProcessDataCompletedTrue() {
    List<String> todoList = new ArrayList<>(Arrays.asList("Clean the room;1"));
    Todos myTodo = myTodoApp.processData(todoList);
    assertEquals(true, myTodo.getTodos().get(0).isCompleted());
  }

  @Test
  public void testProcessDataCompletedFalse() {
    List<String> todoList = new ArrayList<>(Arrays.asList("Clean the room;0"));
    Todos myTodo = myTodoApp.processData(todoList);
    assertEquals(false, myTodo.getTodos().get(0).isCompleted());
  }
}