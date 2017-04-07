import todo.Todo;
import todo.Todos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TodoApp {

  final public static String TODO_TXT = "../../../assets/todo.csv";

  public static void main(String[] args) {
    List<String> todos = readFileLines();
    Todos myTodoList = processData(todos);

    if (args.length == 1) {
      switch (args[0]) {
        case "-l":
          if (myTodoList.getTodos().isEmpty()) {
            System.out.println("No todos for today! :)");
          } else {
            System.out.println(myTodoList.list());
          }
          break;
        case "-a":
          System.out.println("Please write a task after the argument -a");
          break;
        case "-r":
          System.out.println("Unable to remove: no index provided");
          break;
        case "-c":
          System.out.println(myTodoList.toString());
          break;
      }
    } else if (args.length == 2) {
      try {
        if (args[0].equals("-c")) {
          myTodoList.getTodos().get(Integer.parseInt(args[1])-1).complete();
          writeFileLines(reverseData(myTodoList));
        }

        if (args[0].equals("-a")) {
          myTodoList.add(new Todo(args[1],false));
          writeFileLines(reverseData(myTodoList));
        }

        if (args[0].equals("-r")) {
          myTodoList.remove(myTodoList.getTodos().get(Integer.parseInt(args[1])-1));
          writeFileLines(reverseData(myTodoList));
        }

      } catch (Exception e) {
        System.out.println("Exception occured: " + e.getClass());
      }

    } else {
      System.out.println(" \n Java Todo application\n ======================= \n Command line " +
              "arguments: \n -l   Lists all the tasks \n -a   Adds a new task \n -r   Removes " +
              "antask \n -c   Completes an task");
    }
  }

  public static void writeFileLines(List<String> todos) {
    try {
      Path path = Paths.get(TODO_TXT);
      Files.write(path, todos);
    } catch (IOException e) {
      System.out.println("Exception occured: " + e.getClass());
    }
  }

  public static List<String> readFileLines() {
    List<String> lines;
    try {
      Path path = Paths.get(TODO_TXT);
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      System.out.println("Exception occured: " + e.getClass());
      lines = new ArrayList<>();
    }
    return lines;
  }

  public static Todos processData(List<String> rawLines) {
    Todos myTodos = new Todos();

    for (String line : rawLines) {
      String[] splittedLine = line.split(";");

      String todo = splittedLine[0];
      boolean completed = (Integer.parseInt(splittedLine[1]) == 1 ) ? true : false;

      myTodos.add(new Todo(todo, completed));
    }

    return myTodos;
  }

  private static List<String> reverseData(Todos todos) {
    List<String> lines = new ArrayList<>();
    for (int i = 0; i < todos.getTodos().size(); i++) {
      int isCompleted = (todos.getTodos().get(i).isCompleted()) ? 1 : 0;
      lines.add(todos.getTodos().get(i).getName() + ";" +  isCompleted);
    }
    return lines;
  }
}