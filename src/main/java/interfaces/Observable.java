package interfaces;

public interface Observable {
    public abstract void addObserver(Observer o);

    public abstract void deleteObserver(Observer o);

    public abstract void notifyObserver(Observer o);
}
