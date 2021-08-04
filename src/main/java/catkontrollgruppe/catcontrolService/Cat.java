package catkontrollgruppe.catcontrolService;

import com.fasterxml.jackson.annotation.JsonValue;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;



import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import javax.swing.*;

public class Cat {

    private final SimpleStringProperty name;
    private final SimpleIntegerProperty alter;
    private final SimpleStringProperty impfdatum;
    private final SimpleDoubleProperty gewicht;
    private final SimpleBooleanProperty rund;
    private final SimpleBooleanProperty suess;

    public Cat (String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {
        this.name = new SimpleStringProperty(name);
        this.alter = new SimpleIntegerProperty(alter);
        this.impfdatum = new SimpleStringProperty(impfdatum);
        this.gewicht = new SimpleDoubleProperty(gewicht);
        this.rund = new SimpleBooleanProperty(rund);
        this.suess = new SimpleBooleanProperty(suess);
    }

    public Cat() {

        this.name = new SimpleStringProperty("Dummy");
        this.alter = new SimpleIntegerProperty(99);
        this.impfdatum = new SimpleStringProperty("September 2011");
        this.gewicht = new SimpleDoubleProperty(99);
        this.rund = new SimpleBooleanProperty(true);
        this.suess = new SimpleBooleanProperty(true);
    }

    @Override
    public String toString() {
        return "Cat{" + name.get() + '}';
    }

    /**Die Methode miauen erlaubt es den Katzenobjekten zu miauen*/
    public void miauen() {
        System.out.println("Miau");
    }

    /**Die Methode fauchen erlaubt es den Katzenobjekten zu fauchen*/
    public void fauchen() {
        System.out.println("Fauch!!!");
    }

    /**Die Methode schnurren() erlaubt es den Katzenobjekten zu schnurren*/
    public void schnurren() {
        JOptionPane.showMessageDialog(null, "schnurrrr.");
    }

    /**Die Methode essen lässt die Katzenobjekte essen*/
    public void essen() {
        System.out.println("Mampf, mampf, mampf");
    }

// Getter/Setter


    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getAlter() {
        return alter.get();
    }

    public SimpleIntegerProperty alterProperty() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter.set(alter);
    }

    public String getImpfdatum() {
        return impfdatum.get();
    }

    public SimpleStringProperty impfdatumProperty() {
        return impfdatum;
    }

    public void setImpfdatum(String impfdatum) {
        this.impfdatum.set(impfdatum);
    }

    public double getGewicht() {
        return gewicht.get();
    }

    public SimpleDoubleProperty gewichtProperty() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht.set(gewicht);
    }

    public boolean isRund() {
        return rund.get();
    }

    public SimpleBooleanProperty rundProperty() {
        return rund;
    }

    public void setRund(boolean rund) {
        this.rund.set(rund);
    }

    public boolean isSuess() {
        return suess.get();
    }

    public SimpleBooleanProperty suessProperty() {
        return suess;
    }

    public void setSuess(boolean suess) {
        this.suess.set(suess);
    }
}
