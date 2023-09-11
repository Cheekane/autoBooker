package com.autoBooker.page;

public enum GolfCourse1 {
    ThamesClassic(9710),
    ThamesHickory(9711),
    FanshaweTraditional(9714),
    FanshaweQuarry(9713);

    private final int courseId;

    GolfCourse1(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return this.courseId;
    }
}
