package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.AuthorModel;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;
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

    public void searchBook(String query) {
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
                Log.d(TAG, "onResponse: " + response.body());
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        for (int i = 0; i < response.body().size(); i++) {
                            // Getting each element and save it into data base
                            SearchResponse searchResponse = response.body().get(i);
                            Log.i(TAG, "Saving response into database ");
                            saveResultIntoDatabase(searchResponse);


                        }
                    }
                }).start();
            }

            @Override
            public void onFailure(Call<List<SearchResponse>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage().toString());
            }
        });


    }


    public void saveResultIntoDatabase(SearchResponse searchResponse) {

        SampleBookModel sampleBookModel = searchResponse.getSingularBookInfo();
        BookInfoModel bookInfoModel = searchResponse.getBookInfo();
        AuthorModel authorModel = searchResponse.getAuthorsInfo();
        ShelfModel actualShelf = searchResponse.getActualShelf();


        if(authorModel != null) {
            try {
                RoomHelper.getAppDatabaseInstance().authorDao().insert(authorModel);
            }catch (android.database.sqlite.SQLiteConstraintException uniqueConstraint){

            }

        }

        if(bookInfoModel != null){
            try {
                RoomHelper.getAppDatabaseInstance().bookInfoDao().insert(bookInfoModel);
            }catch (android.database.sqlite.SQLiteConstraintException uniqueConstraint){

            }

        }

        if(actualShelf != null){
            try {
                RoomHelper.getAppDatabaseInstance().shelfDao().insert(actualShelf);
            }catch (android.database.sqlite.SQLiteConstraintException uniqueConstraint){

            }

        }

        if(sampleBookModel != null){
            try {
                RoomHelper.getAppDatabaseInstance().sampleBookDao().insert(sampleBookModel);
            }catch (android.database.sqlite.SQLiteConstraintException uniqueConstraint){

            }

        }




    }


    public void deletePreviousResult() {
        /**
         * Delete previous database result
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                RoomHelper.getAppDatabaseInstance().bookInfoDao().deleteAll();
                RoomHelper.getAppDatabaseInstance().authorDao().deleteAll();
                RoomHelper.getAppDatabaseInstance().shelfDao().deleteAll();
                RoomHelper.getAppDatabaseInstance().sampleBookDao().deleteAll();
            }
        });
    }
}
