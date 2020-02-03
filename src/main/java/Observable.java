import java.util.Collection;

public interface Observable {

	private Collection<Observer> observer;

	private Token token;

	public abstract void addObserver(Observer o);

	/**
	 *  
	 */
	public abstract void deleteObserver(Observer o);

	public abstract void notifyObserver(Observer o);

}
