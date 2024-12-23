package org.example.backenddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Bike {
    @TableId(type = IdType.AUTO)
    private int bikeId;
    private String bikeModel;
    private String bikeManufacturer;
    private String bikeType;

    @Override
    public String toString() {
        return "bike{" +
                "bikeId=" + bikeId +
                ", bikeModel='" + bikeModel + '\'' +
                ", bikeManufacturer='" + bikeManufacturer + '\'' +
                ", bikeType='" + bikeType + '\'' +
                '}';
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public String getBikeManufacturer() {
        return bikeManufacturer;
    }

    public void setBikeManufacturer(String bikeManufacturer) {
        this.bikeManufacturer = bikeManufacturer;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
}
