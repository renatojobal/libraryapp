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

/**
 * Singular_Book model
 */
@Entity(tableName = DBConstants.SAMPLE_BOOK_TABLE,
        foreignKeys = {
                @ForeignKey(entity = ShelfModel.class,
                        parentColumns = DBConstants.SHELF_ID,
                        childColumns = DBConstants.SAMPLE_BOOK_SHELF_OWNER_ID,
                        onDelete = ForeignKey.SET_NULL),

                @ForeignKey(entity = ShelfModel.class,
                        parentColumns = DBConstants.SHELF_ID,
                        childColumns = DBConstants.SAMPLE_BOOK_ACTUAL_SHELF_ID,
                        onDelete = ForeignKey.SET_NULL),
                @ForeignKey(entity = BookInfoModel.class,
                        parentColumns = DBConstants.BOOK_INFO_ID,
                        childColumns = DBConstants.SAMPLE_BOOK_BOOK_INFO_ID,
                        onDelete = ForeignKey.CASCADE
                )
        }
)
public class SampleBookModel implements Serializable {


    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_ID)
    private Integer id;

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
    private Integer fkShelfOwner;

    @SerializedName("actual_shelf")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_ACTUAL_SHELF_ID)
    private Integer fkActualShelf;

    @SerializedName("book_info")
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_BOOK_INFO_ID)
    private Integer fkBookInfoModel;

    @SerializedName(DBConstants.SAMPLE_BOOK_BOOK_INFO__TITLE)
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_BOOK_INFO__TITLE)
    private String bookInfoTitle;

    @SerializedName(DBConstants.SAMPLE_BOOK_TOTAL_INTERNAL_LOANS)
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_TOTAL_INTERNAL_LOANS)
    private Integer totalInternalLoans;

    @SerializedName(DBConstants.SAMPLE_BOOK_TOTAL_EXTERNAL_LOANS)
    @ColumnInfo(name = DBConstants.SAMPLE_BOOK_TOTAL_EXTERNAL_LOANS)
    private Integer totalExternalLoans;



    // Getter and setters
    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
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

    public Integer getFkShelfOwner() {
        return fkShelfOwner;
    }

    public void setFkShelfOwner(Integer fkShelfOwner) {
        this.fkShelfOwner = fkShelfOwner;
    }

    public Integer getFkActualShelf() {
        return fkActualShelf;
    }

    public void setFkActualShelf(Integer fkActualShelf) {
        this.fkActualShelf = fkActualShelf;
    }

    public Integer getFkBookInfoModel() {
        return fkBookInfoModel;
    }

    public void setFkBookInfoModel(Integer fkBookInfoModel) {
        this.fkBookInfoModel = fkBookInfoModel;
    }

    public String getBookInfoTitle() {
        return bookInfoTitle;
    }

    public void setBookInfoTitle(String bookInfoTitle) {
        this.bookInfoTitle = bookInfoTitle;
    }

    public Integer getTotalInternalLoans() {
        return totalInternalLoans;
    }

    public void setTotalInternalLoans(Integer totalInternalLoans) {
        this.totalInternalLoans = totalInternalLoans;
    }

    public Integer getTotalExternalLoans() {
        return totalExternalLoans;
    }

    public void setTotalExternalLoans(Integer totalExternalLoans) {
        this.totalExternalLoans = totalExternalLoans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleBookModel that = (SampleBookModel) o;
        return id == that.id &&
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
        return Objects.hash(id, borrowedExternally, borrowedInternally, tag, state, fkShelfOwner, fkActualShelf, fkBookInfoModel);
    }

    @Override
    public String toString() {
        return "SampleBookModel{" +
                "id=" + id +
                ", borrowedExternally=" + borrowedExternally +
                ", borrowedInternally=" + borrowedInternally +
                ", tag='" + tag + '\'' +
                ", state=" + state +
                ", fkShelfOwner=" + fkShelfOwner +
                ", fkActualShelf=" + fkActualShelf +
                ", fkBookInfoModel=" + fkBookInfoModel +
                '}';
    }
}
