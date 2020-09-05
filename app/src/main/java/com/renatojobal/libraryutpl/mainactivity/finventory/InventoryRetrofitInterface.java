package com.renatojobal.libraryutpl.mainactivity.finventory;

import com.google.gson.JsonObject;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InventoryRetrofitInterface {


    /**
     * Pull the existing shelfs
     */
    @GET(ServiceConstants.SHELF_URL)
    Call<List<ShelfModel>> pullShelfs();

    /**
     * Pull the existing books
     */
    @GET(ServiceConstants.BOOK_URL)
    Call<List<BookInfoModel>> pullBooks();

    /**
     * Push a new sample book to the server
     */
    @POST(ServiceConstants.SAMPLE_BOOK_URL)
    Call<JsonObject> pushBook(@Body SampleBookModel targetBook);
}
