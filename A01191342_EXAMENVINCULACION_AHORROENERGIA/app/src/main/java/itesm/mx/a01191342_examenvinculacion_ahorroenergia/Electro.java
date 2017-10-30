package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

/**
 * Created by Jibril on 10/30/17.
 */

public class Electro {

    private long id;
    private String name;
    private int watts;
    private byte[] picture;

    public Electro() {
        this.id = 0;
        this.name = null;
        this.watts = 0;
        this.picture = null;
    }

    public Electro (String name, int watts, byte[] picture) {
        this.name = name;
        this.watts = watts;
        this.picture = picture;
    }

    public Electro (long id, String name, int watts, byte[] picture) {
        this.id = id;
        this.name = name;
        this.watts = watts;
        this.picture = picture;
    }


    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public String getNameE() {
        return name;
    }

    public void setNameE(String name) {
        this.name = name;
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
