import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View implements ViewInterface {
  private ModelInterface modelInterface;
  private ControllerInterface controllerInterface;
  final int NEW_LINE_FOR_CLRSCR = 15;
  
  View(ModelInterface paramModelInterface, ControllerInterface paramControllerInterface) {
    setModel(paramModelInterface);
    setController(paramControllerInterface);
  }
  
  void clearScreen() {
    for (int i = 0; i < NEW_LINE_FOR_CLRSCR; i++) {
      System.out.println();
    }
  }
  
  void setModel(ModelInterface paramModelInterface) {
    this.modelInterface = paramModelInterface;
  }
  
  void setController(ControllerInterface paramControllerInterface) {
    this.controllerInterface = paramControllerInterface;
  }

  @Override
  public void updateModel(ModelInterface paramModel) {
    this.modelInterface = paramModel;
    displayUserInterface();
  }
  
  @Override
  public void displayUserInterface() {
    // display UI based on model
    clearScreen();
    System.out.println("Speed: " + modelInterface.getSpeed());
    System.out.println("Direction: " + modelInterface.getDirCharValue());
    System.out.println("Press 'h' to see help");
    while (true) {
      try {
        char q = (char) System.in.read();
        if (q == 'w'){
          keyIncrementSpeedPressed();
        }
        if (q == 's') {
          keyDecrementSpeedPressed();
        }
        if (q == 'a') {
          keyTurnLeftPressed();
        }
        if (q == 'd') {
          keyTurnRightPressed();
        }
        if (q == 'q') {
          System.exit(0);
        }
      } catch (IOException ex) {
        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  @Override
  public void displayHelp() {
    clearScreen();
    System.out.println("Press 'W' to increase speed by 1");
    System.out.println("Press 'S' to decrease speed by 1");
    System.out.println("Press 'A' to turn left");
    System.out.println("Press 'D' to turn right");
  }

  @Override
  public void keyIncrementSpeedPressed() {
    controllerInterface.incrementSpeed();
  }

  @Override
  public void keyDecrementSpeedPressed() {
    controllerInterface.decrementSpeed();
  }

  @Override
  public void keyTurnLeftPressed() {
    controllerInterface.changeDir(true);
  }

  @Override
  public void keyTurnRightPressed() {
    controllerInterface.changeDir(false);
  }

  @Override
  public void keyInfoPressed() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void keyClosePressed() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}