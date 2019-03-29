public interface ViewInterface {
  void updateModel(ModelInterface paramModel);
  void displayUserInterface();
  void displayHelp();
  void keyIncrementSpeedPressed();
  void keyDecrementSpeedPressed();
  void keyTurnLeftPressed();
  void keyTurnRightPressed();
  void keyInfoPressed();
  void keyClosePressed();
}