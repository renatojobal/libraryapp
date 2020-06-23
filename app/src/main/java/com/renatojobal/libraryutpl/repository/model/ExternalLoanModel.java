package com.renatojobal.libraryutpl.repository.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;

/**
 * External_Loan model
 */
@Entity(foreignKeys = {
        @ForeignKey(entity = SampleBookModel.class,
                parentColumns = DBConstants.SAMPLE_BOOK_ID,
                childColumns = "fkSampleBook",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = PersonModel.class,
                parentColumns = "id",
                childColumns = "fkPerson",
                onDelete = ForeignKey.CASCADE)
})
public class ExternalLoanModel {


    @PrimaryKey
    private int id;

    private int fkSampleBook;

    private int fkPerson;

    private Long loanTime;

    private Long returnExpected;

    private Long dateReturned;

    private int state;

    /**
     * Full params constructor
     * @param id
     * @param fkSampleBook
     * @param fkPerson
     * @param loanTime
     * @param returnExpected
     * @param dateReturned
     * @param state
     */
    public ExternalLoanModel(int id, int fkSampleBook, int fkPerson, Long loanTime, Long returnExpected, Long dateReturned, int state) {
        this.id = id;
        this.fkSampleBook = fkSampleBook;
        this.fkPerson = fkPerson;
        this.loanTime = loanTime;
        this.returnExpected = returnExpected;
        this.dateReturned = dateReturned;
        this.state = state;
    }

    // Getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkSampleBook() {
        return fkSampleBook;
    }

    public void setFkSampleBook(int fkSampleBook) {
        this.fkSampleBook = fkSampleBook;
    }

    public int getFkPerson() {
        return fkPerson;
    }

    public void setFkPerson(int fkPerson) {
        this.fkPerson = fkPerson;
    }

    public Long getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Long loanTime) {
        this.loanTime = loanTime;
    }

    public Long getReturnExpected() {
        return returnExpected;
    }

    public void setReturnExpected(Long returnExpected) {
        this.returnExpected = returnExpected;
    }

    public Long getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Long dateReturned) {
        this.dateReturned = dateReturned;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
