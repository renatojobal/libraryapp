package com.renatojobal.libraryutpl.mainactivity.fsearchbook;


import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Interface that provides endpoints for search book
 */
public interface SearchBookRetrofitInterface {

    /**
     * Search a title into the server using a key word of the title
     * @param searchBookBody key word
     * @return response
     */
    @POST(ServiceConstants.SEARCH_BOOK_BY_TITLE_URL)
    Call<List<SearchResponse>> searchBookByTitle(
            @Body SearchBookBody searchBookBody
            );
}
