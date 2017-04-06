package todo;

public class Todo {
  private String name;
  private boolean completed;

  public Todo(String name, boolean completed) {
    this.name = name;
    this.completed = completed;
  }

  public void complete() {
    if (this.completed) {
      this.completed = false;
    } else {
      this.completed = true;
    }
  }

  public String getName() {
    return name;
  }

  public boolean isCompleted() {
    return completed;
  }

  @Override
  public String toString() {
    return (completed ? "[x] " : "[ ] ") + name;
  }
}
