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
    private String id;
    private Date created;
    private Date activated;
    private String facebookID;
    private boolean active;
    private List<Group> groups;
    private List<User> recentFriends;
    private List<Pin> recentPins;
    private List<Pin> pins;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getActivated() {
        return activated;
    }

    public void setActivated(Date activated) {
        this.activated = activated;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<User> getRecentFriends() {
        return recentFriends;
    }

    public void setRecentFriends(List<User> recentFriends) {
        this.recentFriends = recentFriends;
    }

    public List<Pin> getRecentPins() {
        return recentPins;
    }

    public void setRecentPins(List<Pin> recentPins) {
        this.recentPins = recentPins;
    }

    public List<Pin> getPins() {
        return pins;
    }

    public void setPins(List<Pin> pins) {
        this.pins = pins;
    }
}
