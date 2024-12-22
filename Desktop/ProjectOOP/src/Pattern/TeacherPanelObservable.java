package Pattern;


import java.util.ArrayList;
import java.util.List;

public class TeacherPanelObservable {
    private List<ObserverTeacher> observers = new ArrayList<>();

    public void addObserver(ObserverTeacher observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverTeacher observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (ObserverTeacher observer : observers) {
            observer.update(message);
        }
    }
}
