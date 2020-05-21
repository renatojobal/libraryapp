package com.renatojobal.libraryutpl.repository.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

@Entity(
        foreignKeys = {
                @ForeignKey(entity = ShelfModel.class,
                        parentColumns = "shelfModelId",
                        childColumns = "shelfOwnerId",
                        onDelete = ForeignKey.CASCADE),

                @ForeignKey(entity = ShelfModel.class,
                        parentColumns = "shelfModelId",
                        childColumns = "actualShelfId",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = BookInfoModel.class,
                        parentColumns = "bookInfoModelId",
                        childColumns = "bookInfoModelId",
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
    @SerializedName("id")
    private int sampleBookModelId;

    @SerializedName("borrowed_externally")
    private boolean borrowedExternally;

    @SerializedName("borrowed_internally")
    private boolean borrowedInternally;

    @SerializedName("tag")
    private String tag;

    @SerializedName("state")
    private int state;

    @SerializedName("shelf_owner")
    private int shelfOwnerId;

    @SerializedName("actual_shelf")
    private int actualShelfId;

    @SerializedName("book_info")
    private int bookInfoModelId;


    public SampleBookModel(int sampleBookModelId, boolean borrowedExternally, boolean borrowedInternally, String tag, int state, int shelfOwnerId, int actualShelfId, int bookInfoModelId) {
        /**
         * Full params constructor
         */
        this.sampleBookModelId = sampleBookModelId;
        this.borrowedExternally = borrowedExternally;
        this.borrowedInternally = borrowedInternally;
        this.tag = tag;
        this.state = state;
        this.shelfOwnerId = shelfOwnerId;
        this.actualShelfId = actualShelfId;
        this.bookInfoModelId = bookInfoModelId;
    }

    // Getter and setters
    public int getSampleBookModelId() {
        return sampleBookModelId;
    }

    public void setSampleBookModelId(int sampleBookModelId) {
        this.sampleBookModelId = sampleBookModelId;
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

    public int getShelfOwnerId() {
        return shelfOwnerId;
    }

    public void setShelfOwnerId(int shelfOwnerId) {
        this.shelfOwnerId = shelfOwnerId;
    }

    public int getActualShelfId() {
        return actualShelfId;
    }

    public void setActualShelfId(int actualShelfId) {
        this.actualShelfId = actualShelfId;
    }

    public int getBookInfoModelId() {
        return bookInfoModelId;
    }

    public void setBookInfoModelId(int bookInfoModelId) {
        this.bookInfoModelId = bookInfoModelId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleBookModel that = (SampleBookModel) o;
        return sampleBookModelId == that.sampleBookModelId &&
                borrowedExternally == that.borrowedExternally &&
                borrowedInternally == that.borrowedInternally &&
                state == that.state &&
                shelfOwnerId == that.shelfOwnerId &&
                actualShelfId == that.actualShelfId &&
                bookInfoModelId == that.bookInfoModelId &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sampleBookModelId, borrowedExternally, borrowedInternally, tag, state, shelfOwnerId, actualShelfId, bookInfoModelId);
    }
}
