package catkontrollgruppe.catcontrolService;

import java.util.Comparator;

public class SortierNamen implements Comparator<Cat> {
    @Override
    public int compare(final Cat a1, final Cat a2) {
        return a1.getName().compareToIgnoreCase(a2.getName());
    }
}