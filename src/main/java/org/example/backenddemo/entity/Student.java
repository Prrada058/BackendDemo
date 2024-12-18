package org.example.backenddemo.entity;

public class Student {
    private int STU_CODE;
    private String STU_FNAME;
    private String STU_LNAME;
    private String STU_GENDER;
    private String STU_DOB;

    @Override
    public String toString() {
        return "Student{" +
                "STU_CODE=" + STU_CODE +
                ", STU_FNAME='" + STU_FNAME + '\'' +
                ", STU_LNAME='" + STU_LNAME + '\'' +
                ", STU_GENDER='" + STU_GENDER + '\'' +
                ", STU_DOB='" + STU_DOB + '\'' +
                '}';
    }

    public int getSTU_CODE() {
        return STU_CODE;
    }

    public void setSTU_CODE(int STU_CODE) {
        this.STU_CODE = STU_CODE;
    }

    public String getSTU_FNAME() {
        return STU_FNAME;
    }

    public void setSTU_FNAME(String STU_FNAME) {
        this.STU_FNAME = STU_FNAME;
    }

    public String getSTU_LNAME() {
        return STU_LNAME;
    }

    public void setSTU_LNAME(String STU_LNAME) {
        this.STU_LNAME = STU_LNAME;
    }

    public String getSTU_GENDER() {
        return STU_GENDER;
    }

    public void setSTU_GENDER(String STU_GENDER) {
        this.STU_GENDER = STU_GENDER;
    }

    public String getSTU_DOB() {
        return STU_DOB;
    }

    public void setSTU_DOB(String STU_DOB) {
        this.STU_DOB = STU_DOB;
    }
}
