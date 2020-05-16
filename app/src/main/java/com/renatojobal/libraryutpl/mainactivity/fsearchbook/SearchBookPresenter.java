package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.webservice.ApiClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchBookPresenter {
    /**
     * Manager between the view model and the repository
     */
    private static final String TAG = "SearchBookPresenter";

    public void searchBook(String query){
        /**
         * Search a book and storage into database
         */
        deletePreviousResult();

        SearchBookBody searchBookBody = new SearchBookBody();
        searchBookBody.setTitle(query);
        SearchBookRetrofitInterface searchBookRetrofitInterface =
                ApiClient.getClient().create(SearchBookRetrofitInterface.class);
        Call<List<SearchResponse>> call = searchBookRetrofitInterface.searchBookByTitle(searchBookBody);

        call.enqueue(new Callback<List<SearchResponse>>() {
            @Override
            public void onResponse(Call<List<SearchResponse>> call, Response<List<SearchResponse>> response) {
                Log.d(TAG, "onResponse: "+response.body());

            }

            @Override
            public void onFailure(Call<List<SearchResponse>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage().toString());
            }
        });



    }



    public void deletePreviousResult(){
        /**
         * Delete previous database result
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                RoomHelper.getAppDatabaseInstance().sampleBookDao().deleteAll();
            }
        });
    }
}
