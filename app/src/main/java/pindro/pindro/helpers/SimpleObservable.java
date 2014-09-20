package pindro.pindro.helpers;

import java.util.ArrayList;
import java.util.List;

import pindro.pindro.interfaces.EasyObservable;
import pindro.pindro.interfaces.OnChangeListener;

/**
 * Created by jeff on 9/20/14.
 */
public class SimpleObservable implements EasyObservable {
    private final List<OnChangeListener> listeners = new ArrayList<OnChangeListener>(;)

    @Override
    public void addListener(OnChangeListener listener) {
        synchronized (listeners) {
            listeners.add(listener);
        }
    }

    @Override
    public void removeListener(OnChangeListener listener) {
        synchronized (listeners) {
            listeners.remove(listener);
        }
    }
    
    protected void notifyObservers(final T model) {
        synchronized (listeners) {
            for (OnChangeListener listener : listeners) {
                listener.onChange(model);
            }
        }
    }
}
