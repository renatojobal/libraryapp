package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import androidx.room.DatabaseView;
import androidx.room.Embedded;
import androidx.room.Ignore;

import com.renatojobal.libraryutpl.repository.localdatabase.DBConstants;
import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

import java.io.Serializable;

import timber.log.Timber;


/**
 * This class is a view that joins the tables sample books with the book info
 * and also with the author in next versions
 */
@DatabaseView("SELECT * " +
        "FROM " + DBConstants.BOOK_INFO_TABLE + ", " + DBConstants.SAMPLE_BOOK_TABLE + " " +
        "WHERE " + DBConstants.SAMPLE_BOOK_BOOK_INFO_ID + " = " + DBConstants.BOOK_INFO_ID + ";")
public class BookFull implements Serializable {


    @Embedded()
    public SampleBookModel sampleBook;

    @Embedded()
    public BookInfoModel bookInfo;

    @Ignore
    public ShelfModel actualShelf;

    public BookFull(SampleBookModel sampleBook, BookInfoModel bookInfo) {
        this.sampleBook = sampleBook;
        this.bookInfo = bookInfo;
        resolveActualShelf();
    }

    public SampleBookModel getSampleBook() {
        return sampleBook;
    }

    public void setSampleBook(SampleBookModel sampleBook) {
        this.sampleBook = sampleBook;
    }

    public BookInfoModel getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfoModel bookInfo) {
        this.bookInfo = bookInfo;
    }


    public ShelfModel getActualShelf() {
        return actualShelf;
    }

    public void setActualShelf(ShelfModel actualShelf) {
        this.actualShelf = actualShelf;
    }

    private void resolveActualShelf() {
        try {
            this.actualShelf =
                    RoomHelper.getAppDatabaseInstance().shelfDao().getShelfById(sampleBook.getFkActualShelf());
        } catch (Exception e) {
            Timber.e(e);
            this.actualShelf = null;
        }
    }


}
