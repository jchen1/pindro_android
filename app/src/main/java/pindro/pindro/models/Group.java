package pindro.pindro.models;

import java.util.Date;
import java.util.List;

/**
 * Created by jeff on 9/19/14.
 */
public class Group {
    private String name;
    private int priority;
    private Date timestamp;
    private List<User> members;
}
