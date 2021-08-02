package catkontrollgruppe.catcontrolService;

import java.util.Comparator;

public class SortierGewicht implements Comparator<Cat> {
    @Override
    public int compare(Cat a1, Cat a2) {
        return (int) (a1.getGewicht() - a2.getGewicht());
    }
}