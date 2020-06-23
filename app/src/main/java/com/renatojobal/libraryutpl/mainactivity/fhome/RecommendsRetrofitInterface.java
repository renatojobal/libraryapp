package com.renatojobal.libraryutpl.mainactivity.fhome;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

/**
 * This interface set methods to pull the recommended books from
 * the server
 */
public interface RecommendsRetrofitInterface {

    /**
     * Request list of recommended books
     * @return List of books
     */
    @GET(ServiceConstants.PULL_RECOMMENDED_BOOKS)
    Call<List<BookInfoModel>> getRecommendedBooks();


}
