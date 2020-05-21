package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import androidx.room.DatabaseView;
import androidx.room.Embedded;

import com.renatojobal.libraryutpl.repository.model.AuthorModel;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

@DatabaseView("SELECT BookInfoModel.* , SampleBookModel.state " +
        "FROM BookInfoModel, SampleBookModel " +
        "INNER JOIN BookInfoModel ON BookInfoModel.bookInfoModelId = SampleBookModel.bookInfoModelId")
public class SampleBookFull {
    /**
     * This class is a view that joins the sample books with the book info, author
     */


    @Embedded(prefix = "sampleBook")
    public SampleBookModel sampleBook;

    @Embedded(prefix = "bookInfo")
    public BookInfoModel bookInfo;




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
