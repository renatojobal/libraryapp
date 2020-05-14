package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import com.google.gson.JsonObject;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SearchBookRetrofitInterface {
    /**
     * Interface that provides endpoints for search book
     */

    @GET(ServiceConstants.SEARCH_BOOK_BY_TITLE_URL)
    Call<JsonObject> searchBookByTitle(
            @Body SearchBookBody searchBookBody
            );
}
