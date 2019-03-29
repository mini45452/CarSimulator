public class Controller implements ControllerInterface {
  private ModelInterface modelInterface;
  private ViewInterface viewInterface;
  
  @Override
  public void setViewInterface(ViewInterface paramViewInterface) {
    this.viewInterface = paramViewInterface;
  }
  
  @Override
  public void setModelInterface(ModelInterface paramModelInterface) {
    this.modelInterface = paramModelInterface;
  }

  @Override
  public void incrementSpeed() {
    int nextSpeed = modelInterface.getSpeed() + 1;
    modelInterface.setSpeed(Math.min(modelInterface.getMaxSpeed(), nextSpeed));
    modelInterface.notifyObservers();
    viewInterface.displayUserInterface();
  }

  @Override
  public void decrementSpeed() {
    int nextSpeed = modelInterface.getSpeed() - 1;
    modelInterface.setSpeed(Math.max(0, nextSpeed));
    modelInterface.notifyObservers();
  }

  @Override
  public void changeDir(boolean changeToLeft) {
    int nextDir;
    if (changeToLeft) {
      nextDir = modelInterface.getDir() - 1;
      if (nextDir < 0) {
        nextDir += ModelInterface.NUM_DIR;
      }
    } else {
      nextDir = modelInterface.getDir() + 1;
      if (nextDir >= ModelInterface.NUM_DIR) {
        nextDir -= ModelInterface.NUM_DIR;
      }
    }
    modelInterface.setDir(nextDir);
    modelInterface.notifyObservers();
  }
}