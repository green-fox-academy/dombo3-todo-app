public class TodoApp {
  public static void main(String[] args) {
    argHandler(args);
    }

    public static void argHandler(String[] args) {
      if (args.length > 0) {
        switch (args[0]) {
          case "-l":
            System.out.println("-l");
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
  }
