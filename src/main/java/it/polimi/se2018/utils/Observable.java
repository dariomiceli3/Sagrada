package it.polimi.se2018.utils;

import java.util.ArrayList;
import java.util.List;

public interface Observable<T> {

    public void register(Observer<T> observer);

    public void deregister(Observer<T> observer);

    // maybe this method should be protected
    public void notify(T message);

}
