package com.autoBooker.component;

public enum TimeOfDay {
    Morning("AM"),
    AfterNoon("PM");

    private final String description;

    TimeOfDay(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
