package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SearchBookRetrofitInterface {
    /**
     * Interface that provides endpoints for search book
     */

    @POST(ServiceConstants.SEARCH_BOOK_BY_TITLE_URL)
    Call<List<SearchResponse>> searchBookByTitle(
            @Body SearchBookBody searchBookBody
            );
}
