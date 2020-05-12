package com.renatojobal.libraryutpl.repository.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BookInfoModel {
    /**
     * Book_Info model
     */

    @PrimaryKey
    private int id;

    private String title;

    private int actualStock;

    private int totalStock;

    private Long publicationDate;

    private int pages;

    private String editorial;

    public BookInfoModel(int id, String title, int actualStock, int totalStock, Long publicationDate, int pages, String editorial) {
        /**
         * Full params constructor
         */
        this.id = id;
        this.title = title;
        this.actualStock = actualStock;
        this.totalStock = totalStock;
        this.publicationDate = publicationDate;
        this.pages = pages;
        this.editorial = editorial;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
