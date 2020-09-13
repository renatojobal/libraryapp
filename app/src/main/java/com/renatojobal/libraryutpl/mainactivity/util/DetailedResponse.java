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
    private SampleBookModel singularBookInfo;

    @SerializedName("authors_info")
    private AuthorModel authorsInfo;

    @SerializedName("book_info")
    private BookInfoModel bookInfo;

    @SerializedName("notification")
    private NotificationModel notificationInfo;

    @SerializedName("internal_loan")
    private InternalLoan internalLoanInfo;


    public ShelfModel getActualShelf() {
        return actualShelf;
    }

    public void setActualShelf(ShelfModel actualShelf) {
        this.actualShelf = actualShelf;
    }

    public SampleBookModel getSingularBookInfo() {
        return singularBookInfo;
    }

    public void setSingularBookInfo(SampleBookModel singularBookInfo) {
        this.singularBookInfo = singularBookInfo;
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

    public NotificationModel getNotificationInfo() {
        return notificationInfo;
    }

    public void setNotificationInfo(NotificationModel notificationInfo) {
        this.notificationInfo = notificationInfo;
    }

    public InternalLoan getInternalLoanInfo() {
        return internalLoanInfo;
    }

    public void setInternalLoanInfo(InternalLoan internalLoanInfo) {
        this.internalLoanInfo = internalLoanInfo;
    }
}
