package sample.model;

import java.util.ArrayList;
import java.util.List;

/*
User class represents Singleton design pattern.
*/
public final class User implements IObservable {

    private static User INSTANCE;
    private int score;
    private final List<IObserver> observerList = new ArrayList<>();

    private User() {
        score = 0;
    }

    public static User getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new User();
        }
        return INSTANCE;
    }

    public int getScore() {
        return score;
    }

    public void addPoints(int points) {
        score += points;
    }

    public void clearScore() {
        score = 0;
    }

    @Override
    public void attach(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(IObserver::update);
    }

}
