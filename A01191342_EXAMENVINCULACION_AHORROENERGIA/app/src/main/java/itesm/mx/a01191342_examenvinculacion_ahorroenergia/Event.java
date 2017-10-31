package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import java.sql.Timestamp;

/**
 * Created by Jibril on 10/30/17.
 */

public class Event {

    private long id;
    private String date;
    private String type;
    private byte[] picture;
    private int use;

    public Event() {
        this.id = 0;
        this.date = null;
        this.type = null;
        this.picture = null;
        this.use = 0;
    }

    public Event (String date, String type, byte[] picture, int use) {
        this.date = date;
        this.type = type;
        this.picture = picture;
        this.use = use;
    }

    public Event (long id, String date, String type, byte[] picture, int use) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.picture = picture;
        this.use = use;
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getUse() {
        return use;
    }

    public void setUse(int use) {
        this.use = use;
    }
}
