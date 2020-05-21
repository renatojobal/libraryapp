package com.renatojobal.libraryutpl.mainactivity.fsearchbook

import androidx.room.DatabaseView
import androidx.room.Embedded
import com.renatojobal.libraryutpl.repository.model.AuthorModel
import com.renatojobal.libraryutpl.repository.model.BookInfoModel
import com.renatojobal.libraryutpl.repository.model.SampleBookModel


@DatabaseView(
        """
            SELECT sample_book.*, BookInfoModel.*, AuthorModel.*
            FROM AuthorModel AS author, AuthorBookInfoModel AS author_book, SampleBookModel as sample_book, BookInfoModel AS book_info
            INNER JOIN BookInfoModel ON sample_book.fkBookInfo = book_info.id
            INNER JOIN AuthorModel ON author.id = BookInfoModel.id
            
        """
)
data class SampleBookFull (
    @Embedded
    val sampleBook : SampleBookModel,
    @Embedded
    val bookInfo: BookInfoModel,
    @Embedded
    val author: AuthorModel

)