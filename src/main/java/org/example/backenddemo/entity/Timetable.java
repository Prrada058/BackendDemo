package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Timetable {
    @TableId(type = IdType.AUTO)
    private int timetablePk;
    private int subwayId;
    private int subwayNo;
    private String subwayDirection;
    private String subwayStation;
    private String subwayMode;
    private String subwayTime;

    @Override
    public String toString() {
        return "Timetable{" +
                "timetablePk=" + timetablePk +
                ", subwayId=" + subwayId +
                ", subwayNo=" + subwayNo +
                ", subwayDirection='" + subwayDirection + '\'' +
                ", subwayStation='" + subwayStation + '\'' +
                ", subwayMode='" + subwayMode + '\'' +
                ", subwayTime='" + subwayTime + '\'' +
                '}';
    }

    public int getTimetablePk() {
        return timetablePk;
    }

    public void setTimetablePk(int timetablePk) {
        this.timetablePk = timetablePk;
    }

    public int getSubwayId() {
        return subwayId;
    }

    public void setSubwayId(int subwayId) {
        this.subwayId = subwayId;
    }

    public int getSubwayNo() {
        return subwayNo;
    }

    public void setSubwayNo(int subwayNo) {
        this.subwayNo = subwayNo;
    }

    public String getSubwayDirection() {
        return subwayDirection;
    }

    public void setSubwayDirection(String subwayDirection) {
        this.subwayDirection = subwayDirection;
    }

    public String getSubwayStation() {
        return subwayStation;
    }

    public void setSubwayStation(String subwayStation) {
        this.subwayStation = subwayStation;
    }

    public String getSubwayMode() {
        return subwayMode;
    }

    public void setSubwayMode(String subwayMode) {
        this.subwayMode = subwayMode;
    }

    public String getSubwayTime() {
        return subwayTime;
    }

    public void setSubwayTime(String subwayTime) {
        this.subwayTime = subwayTime;
    }
}