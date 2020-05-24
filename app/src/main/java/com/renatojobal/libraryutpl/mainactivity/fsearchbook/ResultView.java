package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import androidx.room.DatabaseView;
import androidx.room.Embedded;

import com.renatojobal.libraryutpl.repository.model.AuthorModel;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

@DatabaseView("SELECT BookInfoModel.* , SampleBookModel.* " +
        "FROM BookInfoModel, SampleBookModel " +
        "WHERE SampleBookModel.fkBookInfoModel = BookInfoModel.bookInfoModelId")
public class ResultView {
    /**
     * This class is a view that joins the tables sample books with the book info, author
     */


    @Embedded(prefix = "sampleBook")
    public SampleBookModel sampleBook;

    @Embedded(prefix = "bookInfo")
    public BookInfoModel bookInfo;

    public ResultView(SampleBookModel sampleBook, BookInfoModel bookInfo) {
        this.sampleBook = sampleBook;
        this.bookInfo = bookInfo;
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


}
