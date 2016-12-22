package Observer;

import java.util.List;

public interface Subject {

	public void registerObserver(Observer o);
	public void notifyObserver(List<Observer> observers);
}
