package pindro.pindro.models;

import android.graphics.Bitmap;
import android.graphics.PointF;

import java.util.Date;
import java.util.List;

/**
 * Created by jeff on 9/19/14.
 */
public class Pin {
    private User owner;
    private PointF coords;
    private Date timestamp;
    private Date expires;
    private List<User> invitees, attendees;
    private int privacy;
    private Bitmap icon;
    private Bitmap picture;
    private String snippet;
}
