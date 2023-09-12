package com.autoBooker.page;

public enum GolfCourse {
    ThamesClassic(9710),
    ThamesHickory(9711),
    FanshaweTraditional(9714),
    FanshaweQuarry(9713);

    private final int courseId;

    GolfCourse(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return this.courseId;
    }
}
