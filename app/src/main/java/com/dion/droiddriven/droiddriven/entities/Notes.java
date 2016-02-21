package com.dion.droiddriven.droiddriven.entities;

/**
 * Created by Dion on 2/21/2016.
 */
public class Notes {

    private static String titel;
    private static String inhoud;
    private long id;

    public Notes(long id, String titel, String inhoud) {
        this.id = id;
        Notes.titel = titel;
        Notes.inhoud = inhoud;
    }

    public static String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        Notes.titel = titel;
    }

    public static String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        Notes.inhoud = inhoud;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
