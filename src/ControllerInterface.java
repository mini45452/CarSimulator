public interface ControllerInterface {
  void incrementSpeed();
  void decrementSpeed();
  void changeDir(boolean changeToLeft);
  public void setViewInterface(ViewInterface paramViewInterface);
  public void setModelInterface(ModelInterface paramModelInterface);
}