package com.autoBooker.page;

public enum Holes {
    Nine(9),
    EightTeen(18);

    private final int numOfHoles;

    Holes(int numOfHoles) {
        this.numOfHoles = numOfHoles;
    }

    public int getCount() {
        return numOfHoles;
    }
}
