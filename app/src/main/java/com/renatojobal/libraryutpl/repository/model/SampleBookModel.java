package com.renatojobal.libraryutpl.repository.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = DBConstants.SAMPLE_BOOK_TABLE,
        foreignKeys = {
                @ForeignKey(entity = ShelfModel.class,
                        parentColumns = DBConstants.SHELF_ID,
                        childColumns = DBConstants.SAMPLE_BOOK_SHELF_OWNER_ID,
                        onDelete = ForeignKey.CASCADE),

                @ForeignKey(entity = ShelfModel.class,
                        parentColumns = DBConstants.SHELF_ID,
                        childColumns = DBConstants.SAMPLE_BOOK_ACTUAL_SHELF_ID,
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = BookInfoModel.class,
                        parentColumns = DBConstants.BOOK_INFO_ID,
                        childColumns = DBConstants.SAMPLE_BOOK_BOOK_INFO_ID,
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
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_ID)
    private int sampleBookModelId;

    @SerializedName("borrowed_externally")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_BORROWED_EXTERNALLY)
    private boolean borrowedExternally;

    @SerializedName("borrowed_internally")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_BORROWED_INTERNALLY)
    private boolean borrowedInternally;

    @SerializedName("tag")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_TAG)
    private String tag;

    @SerializedName("state")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_STATE)
    private int state;

    @SerializedName("shelf_owner")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_SHELF_OWNER_ID)
    private int fkShelfOwner;

    @SerializedName("actual_shelf")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_ACTUAL_SHELF_ID)
    private int fkActualShelf;

    @SerializedName("book_info")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_BOOK_INFO_ID)
    private int fkBookInfoModel;


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

    public int getFkBookInfoModel() {
        return fkBookInfoModel;
    }

    public void setFkBookInfoModel(int fkBookInfoModel) {
        this.fkBookInfoModel = fkBookInfoModel;
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
                fkShelfOwner == that.fkShelfOwner &&
                fkActualShelf == that.fkActualShelf &&
                fkBookInfoModel == that.fkBookInfoModel &&
                Objects.equals(tag, that.tag);

    }

    @Override
    public int hashCode() {
        return Objects.hash(sampleBookModelId, borrowedExternally, borrowedInternally, tag, state, fkShelfOwner, fkActualShelf, fkBookInfoModel);
    }
}
