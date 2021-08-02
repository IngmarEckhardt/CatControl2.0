package catkontrollgruppe.catcontrolService;

import java.util.Comparator;

public class SortierNamen implements Comparator<Cat> {
    @Override
    public int compare(Cat a1, Cat a2) {
        return a1.getName().compareTo(a2.getName());
    }
}