public interface ViewInterface {
  void updateModel(ModelInterface paramModel);
  void setModel(ModelInterface paramModelInterface);
  void setController(ControllerInterface paramControllerInterface);
  void displayUserInterface();
  void displayHelp();
  void keyIncrementSpeedPressed();
  void keyDecrementSpeedPressed();
  void keyTurnLeftPressed();
  void keyTurnRightPressed();
  void keyInfoPressed();
  void keyClosePressed();
}