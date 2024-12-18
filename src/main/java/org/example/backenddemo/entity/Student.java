package org.example.backenddemo.entity;

public class Student {
    private int stuCode;
    private String stuFname;
    private String stuLname;
    private String stuGender;
    private String stuDob;

    @Override
    public String toString() {
        return "Student{" +
                "stuCode=" + stuCode +
                ", stuFname='" + stuFname + '\'' +
                ", stuLname='" + stuLname + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuDob='" + stuDob + '\'' +
                '}';
    }

    public int getStuCode() {
        return stuCode;
    }

    public void setStuCode(int stuCode) {
        this.stuCode = stuCode;
    }

    public String getStuFname() {
        return stuFname;
    }

    public void setStuFname(String stuFname) {
        this.stuFname = stuFname;
    }

    public String getStuLname() {
        return stuLname;
    }

    public void setStuLname(String stuLname) {
        this.stuLname = stuLname;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuDob() {
        return stuDob;
    }

    public void setStuDob(String stuDob) {
        this.stuDob = stuDob;
    }
}
