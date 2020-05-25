package com.renatojobal.libraryutpl.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

import java.io.Serializable;

@Entity(tableName = DBConstants.BOOK_INFO_TABLE)
public class BookInfoModel implements Serializable {
    /**
     * Book_Info model
     */


    @PrimaryKey
    @ColumnInfo(name = DBConstants.BOOK_INFO_ID)
    @SerializedName("id")
    private int bookInfoModelId;

    @ColumnInfo(name = DBConstants.BOOK_INFO_TITLE)
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = DBConstants.BOOK_INFO_ACTUAL_STOCK)
    @SerializedName("actual_stock")
    private int actualStock;

    @ColumnInfo(name = DBConstants.BOOK_INFO_TOTAL_STOCK)
    @SerializedName("total_stock")
    private int totalStock;

    @ColumnInfo(name = DBConstants.BOOK_INFO_PUBLICATION_DATE)
    @SerializedName("publication_date")
    private Long publicationDate;

    @ColumnInfo(name = DBConstants.BOOK_INFO_PAGES)
    @SerializedName("pages")
    private int pages;

    @ColumnInfo(name = DBConstants.BOOK_INFO_EDITORIAL)
    @SerializedName("editorial")
    private String editorial;

    public BookInfoModel(int bookInfoModelId, String title, int actualStock, int totalStock, Long publicationDate, int pages, String editorial) {
        /**
         * Full params constructor
         */
        this.bookInfoModelId = bookInfoModelId;
        this.title = title;
        this.actualStock = actualStock;
        this.totalStock = totalStock;
        this.publicationDate = publicationDate;
        this.pages = pages;
        this.editorial = editorial;
    }

    // Getter and setters
    public int getBookInfoModelId() {
        return bookInfoModelId;
    }

    public void setBookInfoModelId(int bookInfoModelId) {
        this.bookInfoModelId = bookInfoModelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getActualStock() {
        return actualStock;
    }

    public void setActualStock(int actualStock) {
        this.actualStock = actualStock;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public Long getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Long publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
