package catkontrollgruppe.catcontrolService;

import java.util.Comparator;

public class SortierAlter implements Comparator<Cat> {
    @Override
    public int compare(Cat a1, Cat a2) {
            return a1.getAlter() - a2.getAlter();
        }
    }

