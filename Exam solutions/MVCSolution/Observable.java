import java.util.ArrayList;
import java.util.List;


public class Observable {
    private List<Observer> observers = new ArrayList<Observer>();


    public void attach(Observer o) {
        this.observers.add(o);
    }


    public void detach(Observer o) {
        if (!observers.isEmpty()) {
            observers.remove(o);
        }
    }


    public void notifyObservers(Observable observable) {
        for (Observer observer : observers) {
            observer.update(observable);
        }
    }
}
