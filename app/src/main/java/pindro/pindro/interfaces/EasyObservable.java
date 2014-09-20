package pindro.pindro.interfaces;

import java.util.ArrayList;

/**
 * Created by jeff on 9/20/14.
 */
public interface EasyObservable {
    public void addListener(OnChangeListener listener);
    public void removeListener(OnChangeListener listener);
}
