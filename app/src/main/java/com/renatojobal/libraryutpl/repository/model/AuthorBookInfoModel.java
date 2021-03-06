package com.renatojobal.libraryutpl.repository.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

/**
 * Author_Book_Info model
 * <p>
 * Table for many to many relationship
 */
@Entity(tableName = DBConstants.MM_AUTHOR_BOOK_INFO_TABLE,
        foreignKeys = {
                @ForeignKey(entity = AuthorModel.class,
                        parentColumns = DBConstants.AUTHOR_ID,
                        childColumns = DBConstants.MM_AUTHOR_BOOK_INFO_AUTHOR_ID,
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(entity = BookInfoModel.class,
                        parentColumns = DBConstants.BOOK_INFO_ID,
                        childColumns = DBConstants.MM_AUTHOR_BOOK_INFO_BOOK_INFO_ID,
                        onDelete = ForeignKey.CASCADE)
        })
public class AuthorBookInfoModel {


    @PrimaryKey()
    @ColumnInfo(name = DBConstants.MM_AUTHOR_BOOK_INFO_ID)
    private Integer id;

    @ColumnInfo(name = DBConstants.MM_AUTHOR_BOOK_INFO_AUTHOR_ID)
    private Integer authorModelId;

    @ColumnInfo(name = DBConstants.MM_AUTHOR_BOOK_INFO_BOOK_INFO_ID)
    private Integer bookInfoModelId;

    /**
     * Full params constructor
     * @param id
     * @param authorModelId
     * @param bookInfoModelId
     */
    public AuthorBookInfoModel(Integer id, Integer authorModelId, Integer bookInfoModelId) {
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
