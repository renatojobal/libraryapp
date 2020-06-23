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
    private int id;

    private int notificationType;

    private int fkSampleBook;

    /**
     * Full params constructor
     * @param id
     * @param notificationType
     * @param fkSampleBook
     */
    public NotificationModel(int id, int notificationType, int fkSampleBook) {
        this.id = id;
        this.notificationType = notificationType;
        this.fkSampleBook = fkSampleBook;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public int getFkSampleBook() {
        return fkSampleBook;
    }

    public void setFkSampleBook(int fkSampleBook) {
        this.fkSampleBook = fkSampleBook;
    }
}
