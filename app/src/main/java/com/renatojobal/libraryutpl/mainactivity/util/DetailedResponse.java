package com.renatojobal.libraryutpl.mainactivity.util;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.model.AuthorModel;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;
import com.renatojobal.libraryutpl.repository.model.NotificationModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

/**
 * Class for serialized a detailed model response
 */
public class DetailedResponse {

    @SerializedName("actual_shelf")
    private ShelfModel actualShelf;

    @SerializedName("singular_book")
    private SampleBookModel singularBook;

    @SerializedName("authors_info")
    private AuthorModel authorsInfo;

    @SerializedName("book_info")
    private BookInfoModel bookInfo;

    @SerializedName("notification")
    private NotificationModel notification;

    @SerializedName("internal_loan")
    private InternalLoan internalLoan;


    public ShelfModel getActualShelf() {
        return actualShelf;
    }

    public void setActualShelf(ShelfModel actualShelf) {
        this.actualShelf = actualShelf;
    }

    public SampleBookModel getSingularBook() {
        return singularBook;
    }

    public void setSingularBook(SampleBookModel singularBook) {
        this.singularBook = singularBook;
    }

    public AuthorModel getAuthorsInfo() {
        return authorsInfo;
    }

    public void setAuthorsInfo(AuthorModel authorsInfo) {
        this.authorsInfo = authorsInfo;
    }

    public BookInfoModel getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfoModel bookInfo) {
        this.bookInfo = bookInfo;
    }

    public NotificationModel getNotification() {
        return notification;
    }

    public void setNotification(NotificationModel notification) {
        this.notification = notification;
    }

    public InternalLoan getInternalLoan() {
        return internalLoan;
    }

    public void setInternalLoan(InternalLoan internalLoan) {
        this.internalLoan = internalLoan;
    }

    @Override
    public String toString() {
        return "DetailedResponse{" +
                "actualShelf=" + actualShelf +
                ", singularBook=" + singularBook +
                ", authorsInfo=" + authorsInfo +
                ", bookInfo=" + bookInfo +
                ", notification=" + notification +
                ", internalLoan=" + internalLoan +
                '}';
    }
}
