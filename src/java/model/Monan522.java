package model;

import java.util.Date;

public class Monan522 {
    private int id;
    private String name;
    private float dongia;

    public Monan522() {
    }

    public Monan522(String name, float dongia) {
        this.name = name;
        this.dongia = dongia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public String toString() {
        return id+" "+name+" "+dongia;
    }
}

