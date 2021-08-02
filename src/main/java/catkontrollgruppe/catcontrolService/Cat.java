package catkontrollgruppe.catcontrolService;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.swing.*;

public class Cat {

    private SimpleStringProperty name;
    private SimpleIntegerProperty alter;
    private SimpleStringProperty impfdatum;
    private SimpleDoubleProperty gewicht;
    private SimpleBooleanProperty rund;
    private SimpleBooleanProperty suess;

    //Konstruktor
    public Cat (String name, int alter, String impfdatum, double gewicht, boolean rund, boolean suess) {
        this.name = new SimpleStringProperty(name);
        this.alter = new SimpleIntegerProperty(alter);
        this.impfdatum = new SimpleStringProperty(impfdatum);
        this.gewicht = new SimpleDoubleProperty(gewicht);
        this.rund = new SimpleBooleanProperty(rund);
        this.suess = new SimpleBooleanProperty(suess);
    }

    //Konstruktor Dummy
    public Cat() {

        this.name = new SimpleStringProperty((String)"Dummy");
        this.alter = new SimpleIntegerProperty((int) 99);
        this.impfdatum = new SimpleStringProperty((String)"September 2011");
        this.gewicht = new SimpleDoubleProperty((double) 99);
        this.rund = new SimpleBooleanProperty((boolean) true);
        this.suess = new SimpleBooleanProperty((boolean) true);
    }

//toString für bessere Erkennbarkeit im Datensatz
    @Override
    public String toString() {
        return "Cat{" + name.get() + '}';
    }

// Inhärente Fähigkeiten der Katze

    public void miauen() {
        System.out.println("Miau");
    }

    public void fauchen() {
        System.out.println("Fauch!!!");
    }
    /**Die Methode schnurren() erlaubt es den Katzenobjekten zu schnurren*/
    public void schnurren() {
        System.out.println("Schnurr");
        JOptionPane.showMessageDialog(null, "schnurrrr.");
    }

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
