package com.renatojobal.libraryutpl.mainactivity.finventory;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.SearchBookBody;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;
import com.renatojobal.libraryutpl.repository.webservice.ServiceConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface InventoryRetrofitInterface {


    /**
     * Pull the existing shelfs
     */
    @POST(ServiceConstants.PULL_SHELFS)
    Call<List<ShelfModel>> pullShelfs();

    /**
     * Pull the existing books
     */
    @POST(ServiceConstants.PULL_BOOKS)
    Call<List<BookInfoModel>> pullBooks();
}
