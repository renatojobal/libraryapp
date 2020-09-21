package com.renatojobal.libraryutpl.repository.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

/**
 * Internal loan model
 */
@Entity(tableName = DBConstants.INTERNAL_LOAN_TABLE,
foreignKeys = {
        @ForeignKey(entity = SampleBookModel.class,
                parentColumns = DBConstants.SAMPLE_BOOK_ID,
                childColumns = DBConstants.INTERNAL_LOAN_SINGULAR_BOOK_ID,
                onDelete = ForeignKey.SET_NULL)
})
public class InternalLoan {



    @PrimaryKey
    @ColumnInfo(name = DBConstants.INTERNAL_LOAN_ID)
    @SerializedName("id")
    private Integer internalLoanId;

    @ColumnInfo(name = DBConstants.INTERNAL_LOAN_LOAN_TIME)
    private Long loanTime;

    @ColumnInfo(name = DBConstants.INTERNAL_LOAN_TIME_RETURNED)
    private Long timeReturned;

    @SerializedName("loan_time")
    private String loanTimeStringRepresentation;

    @SerializedName("time_returned")
    private String timeReturnedStringRepresentation;


    @ColumnInfo(name = DBConstants.INTERNAL_LOAN_ACTIVE)
    @SerializedName("active")
    private Boolean active;

    @ColumnInfo(name = DBConstants.INTERNAL_LOAN_SINGULAR_BOOK_ID)
    @SerializedName("singular_book")
    private Integer fkSampleBook;

    public InternalLoan(Integer internalLoanId, Long loanTime, Long timeReturned, String loanTimeStringRepresentation, String timeReturnedStringRepresentation, Boolean active, Integer fkSampleBook) {
        this.internalLoanId = internalLoanId;
        this.loanTime = loanTime;
        this.timeReturned = timeReturned;
        this.loanTimeStringRepresentation = loanTimeStringRepresentation;
        this.timeReturnedStringRepresentation = timeReturnedStringRepresentation;
        this.active = active;
        this.fkSampleBook = fkSampleBook;
    }

    public Integer getInternalLoanId() {
        return internalLoanId;
    }

    public void setInternalLoanId(Integer internalLoanId) {
        this.internalLoanId = internalLoanId;
    }

    public Long getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Long loanTime) {
        this.loanTime = loanTime;
    }

    public Long getTimeReturned() {
        return timeReturned;
    }

    public void setTimeReturned(Long timeReturned) {
        this.timeReturned = timeReturned;
    }

    public String getLoanTimeStringRepresentation() {
        return loanTimeStringRepresentation;
    }

    public void setLoanTimeStringRepresentation(String loanTimeStringRepresentation) {
        this.loanTimeStringRepresentation = loanTimeStringRepresentation;
    }

    public String getTimeReturnedStringRepresentation() {
        return timeReturnedStringRepresentation;
    }

    public void setTimeReturnedStringRepresentation(String timeReturnedStringRepresentation) {
        this.timeReturnedStringRepresentation = timeReturnedStringRepresentation;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getFkSampleBook() {
        return fkSampleBook;
    }

    public void setFkSampleBook(Integer fkSampleBook) {
        this.fkSampleBook = fkSampleBook;
    }

    @Override
    public String toString() {
        return "InternalLoan{" +
                "internalLoanId=" + internalLoanId +
                ", loanTime=" + loanTime +
                ", timeReturned=" + timeReturned +
                ", loanTimeStringRepresentation='" + loanTimeStringRepresentation + '\'' +
                ", timeReturnedStringRepresentation='" + timeReturnedStringRepresentation + '\'' +
                ", active=" + active +
                ", fkSampleBook=" + fkSampleBook +
                '}';
    }
}
