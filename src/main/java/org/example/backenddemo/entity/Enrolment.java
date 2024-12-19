package org.example.backenddemo.entity;

public class Enrolment {
    private int stuCode;
    private int courseCode;
    private int enrolYear;
    private int enrolMark;

    @Override
    public String toString() {
        return "Enrolment{" +
                "stuCode=" + stuCode +
                ", courseCode=" + courseCode +
                ", enrolYear=" + enrolYear +
                ", enrolMark=" + enrolMark +
                '}';
    }

    public int getStuCode() {
        return stuCode;
    }

    public void setStuCode(int stuCode) {
        this.stuCode = stuCode;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public int getEnrolYear() {
        return enrolYear;
    }

    public void setEnrolYear(int enrolYear) {
        this.enrolYear = enrolYear;
    }

    public int getEnrolMark() {
        return enrolMark;
    }

    public void setEnrolMark(int enrolMark) {
        this.enrolMark = enrolMark;
    }
}
