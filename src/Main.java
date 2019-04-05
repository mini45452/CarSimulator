public class Main {
  public static void main(String[] args) {
    ModelInterface m = new Model();
    ControllerInterface c = new Controller();
    ViewInterface view = new View(m, c);
    c.setModelInterface(m);
    c.setViewInterface(view);
    m.addObserver(view);
    view.displayUserInterface();
  }
}