package catkontrollgruppe.catcontrolService;

import java.util.Comparator;

public class SortierGewicht implements Comparator<Cat> {
    @Override
    public int compare(final Cat a1, final Cat a2) {
        return (int) (a1.getGewicht() - a2.getGewicht());
    }
}