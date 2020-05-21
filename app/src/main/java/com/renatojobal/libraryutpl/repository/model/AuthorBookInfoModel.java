package com.renatojobal.libraryutpl.repository.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = AuthorModel.class,
                parentColumns = "authorModelId",
                childColumns = "authorModelId",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(entity = BookInfoModel.class,
                parentColumns = "bookInfoModelId",
                childColumns = "bookInfoModelId",
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

    private int authorModelId;

    private int bookInfoModelId;

    public AuthorBookInfoModel(int id, int authorModelId, int bookInfoModelId) {
        /**
         * Full params constructor
         */
        this.id = id;
        this.authorModelId = authorModelId;
        this.bookInfoModelId = bookInfoModelId;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorModelId() {
        return authorModelId;
    }

    public void setAuthorModelId(int authorModelId) {
        this.authorModelId = authorModelId;
    }

    public int getBookInfoModelId() {
        return bookInfoModelId;
    }

    public void setBookInfoModelId(int bookInfoModelId) {
        this.bookInfoModelId = bookInfoModelId;
    }
}
