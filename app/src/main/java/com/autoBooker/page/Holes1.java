package com.autoBooker.page;

public enum Holes1 {
    Nine(9),
    EightTeen(18);

    private final int numOfHoles;

    Holes1(int numOfHoles) {
        this.numOfHoles = numOfHoles;
    }

    public int getCount() {
        return numOfHoles;
    }
}
