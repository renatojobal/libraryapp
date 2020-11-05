package com.renatojobal.libraryutpl.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

import java.io.Serializable;

/**
 * Shelf model
 */
@Entity(tableName = DBConstants.SHELF_TABLE)
public class ShelfModel implements Serializable {


    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = DBConstants.SHELF_ID)
    private Integer shelfModelId;

    @SerializedName("code")
    @ColumnInfo(name = DBConstants.SHELF_CODE)
    private String code;

    @SerializedName("location")
    @ColumnInfo(name = DBConstants.SHELF_LOCATION)
    private String location;

    @SerializedName("active")
    @ColumnInfo(name = DBConstants.SHELF_ACTIVE)
    private boolean active;

    @SerializedName("area")
    @ColumnInfo(name = DBConstants.SHELF_AREA)
    private String area;

    @SerializedName("section")
    @ColumnInfo(name = DBConstants.SHELF_SECTION)
    private String section;

    public ShelfModel(Integer shelfModelId, String code, String location, boolean active, String area, String section) {
        this.shelfModelId = shelfModelId;
        this.code = code;
        this.location = location;
        this.active = active;
        this.area = area;
        this.section = section;
    }

    public Integer getShelfModelId() {
        return shelfModelId;
    }

    public void setShelfModelId(Integer shelfModelId) {
        this.shelfModelId = shelfModelId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Anaquel "+code+" "+location;
    }
}
