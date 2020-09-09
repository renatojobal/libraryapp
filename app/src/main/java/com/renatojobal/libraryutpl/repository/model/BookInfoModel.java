package com.renatojobal.libraryutpl.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

import java.io.Serializable;

/**
 * Book_Info model
 */
@Entity(tableName = DBConstants.BOOK_INFO_TABLE)
public class BookInfoModel implements Serializable {


    @PrimaryKey
    @ColumnInfo(name = DBConstants.BOOK_INFO_ID)
    @SerializedName("id")
    private Integer bookInfoModelId;

    @ColumnInfo(name = DBConstants.BOOK_INFO_TITLE)
    @SerializedName("title")
    private String title;

    @ColumnInfo(name = DBConstants.BOOK_INFO_BOOK_IMAGE)
    @SerializedName("book_image")
    private String bookImage;

    @ColumnInfo(name = DBConstants.BOOK_INFO_ABSTRACT)
    @SerializedName("abstract")
    private String bookAbstract;

    @ColumnInfo(name = DBConstants.BOOK_INFO_ACTUAL_STOCK)
    @SerializedName("actual_stock")
    private int actualStock;

    @ColumnInfo(name = DBConstants.BOOK_INFO_TOTAL_STOCK)
    @SerializedName("total_stock")
    private int totalStock;

    @ColumnInfo(name = DBConstants.BOOK_INFO_PUBLICATION_DATE)
    private Long publicationDate;

    @SerializedName("publication_date")
    private String publicationDateStringRepresentation;

    @ColumnInfo(name = DBConstants.BOOK_INFO_PAGES)
    @SerializedName("pages")
    private int pages;

    @ColumnInfo(name = DBConstants.BOOK_INFO_EDITORIAL)
    @SerializedName("editorial")
    private String editorial;

    public BookInfoModel(Integer bookInfoModelId, String title, String bookImage, String bookAbstract, int actualStock, int totalStock, Long publicationDate, String publicationDateStringRepresentation, int pages, String editorial) {
        this.bookInfoModelId = bookInfoModelId;
        this.title = title;
        this.bookImage = bookImage;
        this.bookAbstract = bookAbstract;
        this.actualStock = actualStock;
        this.totalStock = totalStock;
        this.publicationDate = publicationDate;
        this.publicationDateStringRepresentation = publicationDateStringRepresentation;
        this.pages = pages;
        this.editorial = editorial;
    }

    public Integer getBookInfoModelId() {
        return bookInfoModelId;
    }

    public void setBookInfoModelId(Integer bookInfoModelId) {
        this.bookInfoModelId = bookInfoModelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookAbstract() {
        return bookAbstract;
    }

    public void setBookAbstract(String bookAbstract) {
        this.bookAbstract = bookAbstract;
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

    public String getPublicationDateStringRepresentation() {
        return publicationDateStringRepresentation;
    }

    public void setPublicationDateStringRepresentation(String publicationDateStringRepresentation) {
        this.publicationDateStringRepresentation = publicationDateStringRepresentation;
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

    @Override
    public String toString() {
        return title;
    }
}
