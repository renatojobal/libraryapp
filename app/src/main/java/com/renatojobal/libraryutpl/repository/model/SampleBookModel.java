package com.renatojobal.libraryutpl.repository.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(
        foreignKeys = {
                @ForeignKey(entity = ShelfModel.class,
                        parentColumns = "id",
                        childColumns = "fkShelfOwner",
                        onDelete = ForeignKey.CASCADE),

                @ForeignKey(entity = ShelfModel.class,
                        parentColumns = "id",
                        childColumns = "fkActualShelf",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = BookInfoModel.class,
                        parentColumns = "id",
                        childColumns = "fkBookInfo",
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class SampleBookModel implements Serializable {
    /**
     * Singular_Book model
     */

    @PrimaryKey
    @NonNull
    private int id;

    private boolean borrowedExternally;

    private boolean borrowedInternally;

    private String tag;

    private int state;

    private int fkShelfOwner;

    private int fkActualShelf;

    private int fkBookInfo;

    public SampleBookModel(int id, boolean borrowedExternally, boolean borrowedInternally, String tag, int state, int fkShelfOwner, int fkActualShelf, int fkBookInfo) {
        /**
         * Full params constructor
         */
        this.id = id;
        this.borrowedExternally = borrowedExternally;
        this.borrowedInternally = borrowedInternally;
        this.tag = tag;
        this.state = state;
        this.fkShelfOwner = fkShelfOwner;
        this.fkActualShelf = fkActualShelf;
        this.fkBookInfo = fkBookInfo;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBorrowedExternally() {
        return borrowedExternally;
    }

    public void setBorrowedExternally(boolean borrowedExternally) {
        this.borrowedExternally = borrowedExternally;
    }

    public boolean isBorrowedInternally() {
        return borrowedInternally;
    }

    public void setBorrowedInternally(boolean borrowedInternally) {
        this.borrowedInternally = borrowedInternally;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFkShelfOwner() {
        return fkShelfOwner;
    }

    public void setFkShelfOwner(int fkShelfOwner) {
        this.fkShelfOwner = fkShelfOwner;
    }

    public int getFkActualShelf() {
        return fkActualShelf;
    }

    public void setFkActualShelf(int fkActualShelf) {
        this.fkActualShelf = fkActualShelf;
    }

    public int getFkBookInfo() {
        return fkBookInfo;
    }

    public void setFkBookInfo(int fkBookInfo) {
        this.fkBookInfo = fkBookInfo;
    }
}
