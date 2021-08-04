package catkontrollgruppe.catcontrolService;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.swing.*;

public class Cat {

    private final SimpleStringProperty name;
    private final SimpleIntegerProperty alter;
    private final SimpleStringProperty impfdatum;
    private final SimpleDoubleProperty gewicht;
    private final SimpleBooleanProperty rund;
    private final SimpleBooleanProperty suess;

    public Cat (final String name, final int alter, final String impfdatum, final double gewicht, final boolean rund, final boolean suess) {
        this.name = new SimpleStringProperty(name);
        this.alter = new SimpleIntegerProperty(alter);
        this.impfdatum = new SimpleStringProperty(impfdatum);
        this.gewicht = new SimpleDoubleProperty(gewicht);
        this.rund = new SimpleBooleanProperty(rund);
        this.suess = new SimpleBooleanProperty(suess);
    }

    public Cat() {

        name = new SimpleStringProperty("Dummy");
        alter = new SimpleIntegerProperty(99);
        impfdatum = new SimpleStringProperty("September 2011");
        gewicht = new SimpleDoubleProperty(99);
        rund = new SimpleBooleanProperty(true);
        suess = new SimpleBooleanProperty(true);
    }

    @Override
    public String toString() {
        return "Cat{" + this.name.get() + '}';
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
        return this.name.get();
    }

    public SimpleStringProperty nameProperty() {
        return this.name;
    }

    public void setName(final String name) {
        this.name.set(name);
    }

    public int getAlter() {
        return this.alter.get();
    }

    public SimpleIntegerProperty alterProperty() {
        return this.alter;
    }

    public void setAlter(final int alter) {
        this.alter.set(alter);
    }

    public String getImpfdatum() {
        return this.impfdatum.get();
    }

    public SimpleStringProperty impfdatumProperty() {
        return this.impfdatum;
    }

    public void setImpfdatum(final String impfdatum) {
        this.impfdatum.set(impfdatum);
    }

    public double getGewicht() {
        return this.gewicht.get();
    }

    public SimpleDoubleProperty gewichtProperty() {
        return this.gewicht;
    }

    public void setGewicht(final double gewicht) {
        this.gewicht.set(gewicht);
    }

    public boolean isRund() {
        return this.rund.get();
    }

    public SimpleBooleanProperty rundProperty() {
        return this.rund;
    }

    public void setRund(final boolean rund) {
        this.rund.set(rund);
    }

    public boolean isSuess() {
        return this.suess.get();
    }

    public SimpleBooleanProperty suessProperty() {
        return this.suess;
    }

    public void setSuess(final boolean suess) {
        this.suess.set(suess);
    }
}