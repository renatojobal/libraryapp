package com.renatojobal.libraryutpl.repository.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * Notification model
 */
@Entity(foreignKeys = @ForeignKey(entity = SampleBookModel.class,
        parentColumns = "id",
        childColumns = "fkSampleBook"))
public class NotificationModel {


    @PrimaryKey
    private Integer id;

    private Integer notificationType;

    private Integer fkSampleBook;

    /**
     * Full params constructor
     * @param id
     * @param notificationType
     * @param fkSampleBook
     */
    public NotificationModel(Integer id, Integer notificationType, Integer fkSampleBook) {
        this.id = id;
        this.notificationType = notificationType;
        this.fkSampleBook = fkSampleBook;
    }

    // Getter and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
