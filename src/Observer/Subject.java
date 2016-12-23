package Observer;
/*
 * @Author Gezamenlijk gemaakt
 */
public interface Subject {

	public void registerObserver(Observer o);
	public void notifyObservers();
}
