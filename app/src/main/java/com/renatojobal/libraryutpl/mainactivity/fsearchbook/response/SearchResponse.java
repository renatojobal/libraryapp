package com.renatojobal.libraryutpl.mainactivity.fsearchbook.response;

import com.google.gson.annotations.SerializedName;
import com.renatojobal.libraryutpl.repository.model.AuthorModel;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

public class SearchResponse{

    @SerializedName("actual_shelf")
    private ShelfModel actualShelf;

    @SerializedName("singular_book_info")
    private SampleBookModel singularBookInfo;

    @SerializedName("authors_info")
    private AuthorModel authorsInfo;

    @SerializedName("book_info")
    private BookInfoModel bookInfo;

    public ShelfModel getActualShelf(){
        return actualShelf;
    }

    public SampleBookModel getSingularBookInfo(){
        return singularBookInfo;
    }

    public AuthorModel getAuthorsInfo(){
        return authorsInfo;
    }

    public BookInfoModel getBookInfo(){
        return bookInfo;
    }
}