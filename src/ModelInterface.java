public interface ModelInterface {
  final int NUM_DIR = 4;
  int getSpeed();
  void setSpeed(int paramSpeed);
  int getDir();
  void setDir(int paramDir);
  char getDirCharValue();
  int getMaxSpeed();
  void addObserver(ViewInterface paramViewInterface);
  void removeObserver(ViewInterface paramViewInterface);
  void notifyObservers();
}