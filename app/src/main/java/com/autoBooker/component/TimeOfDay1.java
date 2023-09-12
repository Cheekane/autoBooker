package com.autoBooker.component;

public enum TimeOfDay1 {
    Morning("AM"),
    AfterNoon("PM");

    private final String description;

    TimeOfDay1(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
