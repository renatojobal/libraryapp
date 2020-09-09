package com.renatojobal.libraryutpl.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

/**
 * Notification model
 */
@Entity(tableName = DBConstants.NOTIFICATION_TABLE,
        foreignKeys = @ForeignKey(entity = SampleBookModel.class,
                parentColumns = DBConstants.SAMPLE_BOOK_ID,
                childColumns = DBConstants.NOTIFICATION_SAMPLE_BOOK_ID))
public class NotificationModel {


    @PrimaryKey
    @ColumnInfo(name = DBConstants.NOTIFICATION_ID)
    @SerializedName("id")
    private Integer id;

    @ColumnInfo(name = DBConstants.NOTIFICATION_MESSAGE)
    @SerializedName("message")
    private String message;

    @ColumnInfo(name = DBConstants.NOTIFICATION_TYPE)
    @SerializedName("notification_type")
    private Integer notificationType;

    @ColumnInfo(name = DBConstants.NOTIFICATION_SAMPLE_BOOK_ID)
    @SerializedName("singular_book")
    private Integer fkSampleBook;

    /**
     * Constructor
     * @param id
     * @param message
     * @param notificationType
     * @param fkSampleBook
     */
    public NotificationModel(Integer id, String message, Integer notificationType, Integer fkSampleBook) {
        this.id = id;
        this.message = message;
        this.notificationType = notificationType;
        this.fkSampleBook = fkSampleBook;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(Integer notificationType) {
        this.notificationType = notificationType;
    }

    public Integer getFkSampleBook() {
        return fkSampleBook;
    }

    public void setFkSampleBook(Integer fkSampleBook) {
        this.fkSampleBook = fkSampleBook;
    }
}
