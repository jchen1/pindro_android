package pindro.pindro.interfaces;

import java.util.ArrayList;

/**
 * Created by jeff on 9/20/14.
 */
public interface EasyObservable<T> {
    public void addListener(OnChangeListener<T> listener);
    public void removeListener(OnChangeListener<T> listener);
}
