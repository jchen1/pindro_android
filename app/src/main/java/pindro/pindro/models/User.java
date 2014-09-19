package pindro.pindro.models;

import java.util.Date;
import java.util.List;

/**
 * Created by jeff on 9/19/14.
 */
public class User {
    private String username;
    private String name;
    private String email;
    private Date created;
    private Date activated;
    private String facebookID;
    private boolean active;
    private List<Group> groups;
    private List<User> recentFriends;
    private List<Pin> recentPins;
    private List<Pin> pins;
}
