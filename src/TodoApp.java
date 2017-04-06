import com.sun.org.apache.xpath.internal.SourceTree;
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
    if (args.length > 0) {
      switch (args[0]) {
        case "-l":
          List<String> todos = readFileLines();
          Todos myTodoList = processData(todos);
          System.out.println(myTodoList.list());
          break;
        case "-a":
          System.out.println("-a");
          break;
        case "-r":
          System.out.println("-r");
          break;
        case "-c":
          System.out.println("-c");
          break;
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



  private static Todos processData(List<String> rawLines) {
    Todos myTodos = new Todos();

    for (String line : rawLines) {
      String[] splittedLine = line.split(";");

      String todo = splittedLine[0];
      boolean completed = (Integer.parseInt(splittedLine[1]) == 1 ) ? true : false;

      myTodos.add(new Todo(todo, completed));
    }

    return myTodos;
  }
}

