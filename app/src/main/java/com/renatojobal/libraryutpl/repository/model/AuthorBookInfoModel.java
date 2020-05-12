package com.renatojobal.libraryutpl.repository.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = AuthorModel.class,
                parentColumns = "id",
                childColumns = "fkAuthor",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(entity = BookInfoModel.class,
                parentColumns = "id",
                childColumns = "fkBookInfo",
                onDelete = ForeignKey.CASCADE)
})
public class AuthorBookInfoModel {
    /**
     * Author_Book_Info model
     *
     * Table for many to many relationship
     */

    @PrimaryKey
    @NonNull
    private int id;

    private int fkAuthor;

    private int fkBookInfo;

    public AuthorBookInfoModel(int id, int fkAuthor, int fkBookInfo) {
        /**
         * Full params constructor
         */
        this.id = id;
        this.fkAuthor = fkAuthor;
        this.fkBookInfo = fkBookInfo;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkAuthor() {
        return fkAuthor;
    }

    public void setFkAuthor(int fkAuthor) {
        this.fkAuthor = fkAuthor;
    }

    public int getFkBookInfo() {
        return fkBookInfo;
    }

    public void setFkBookInfo(int fkBookInfo) {
        this.fkBookInfo = fkBookInfo;
    }
}
