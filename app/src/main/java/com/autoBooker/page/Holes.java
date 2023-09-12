package com.autoBooker.page;

// would be public class Holes extends enum, but its short term
public enum Holes {

    NINE(9),
    EIGHTEEN(18);

    private final int numOfHoles;

    Holes(int numOfHoles) {
        this.numOfHoles = numOfHoles;
    }

    public int getCount() {
        return numOfHoles;
    }
}