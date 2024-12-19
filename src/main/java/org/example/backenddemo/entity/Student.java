package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

public class Student {
    @TableId(type = IdType.INPUT)
    private int stuCode;
    private String stuFname;
    private String stuLname;

    @TableField(exist = false)
    private List<Enrolment> enrolments;

    @Override
    public String toString() {
        return "Student{" +
                "stuCode=" + stuCode +
                ", stuFname='" + stuFname + '\'' +
                ", stuLname='" + stuLname + '\'' +
                ", enrolments=" + enrolments +
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

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(List<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }
}
