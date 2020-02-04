package interfaces;

import java.util.List;

public interface Observable {
    public abstract void addObserver(Observer o);

    public abstract void deleteObserver(Observer o);

    public abstract void notifyObservers(List<Observer> obs);
}
