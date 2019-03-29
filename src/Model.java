import java.util.ArrayList;

public class Model implements ModelInterface {
  private int speed;
  private int dir;
  private ArrayList<ViewInterface> observers = new ArrayList<ViewInterface>();
  final int MAX_SPEED = 120;
  
  @Override
  public int getSpeed() {
    return speed;
  }

  @Override
  public void setSpeed(int paramSpeed) {
    this.speed = paramSpeed;
  }

  @Override
  public int getDir() {
    return dir;
  }
  
  @Override
  public char getDirCharValue() {
    if (dir == 0) {
      return 'N';
    }
    if (dir == 1) {
      return 'E';
    }
    if (dir == 2) {
      return 'S';
    }
    return 'W';
  }

  @Override
  public void setDir(int paramDir) {
    this.dir = paramDir;
  }

  @Override
  public int getMaxSpeed() {
    return MAX_SPEED;
  }
  
  @Override
  public void addObserver(ViewInterface paramViewInterface) {
    observers.add(paramViewInterface);
  }

  @Override
  public void removeObserver(ViewInterface paramViewInterface) {
    observers.remove(paramViewInterface);
  }

  @Override
  public void notifyObservers() {
    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).updateModel(this);
    }
  }
}