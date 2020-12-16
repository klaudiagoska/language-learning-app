package sample.model;

/*
IObservable interface represents Observer design pattern.
 */
public interface IObservable {

    void attach(IObserver observer);
    void detach(IObserver observer);
    void notifyObservers();
}
