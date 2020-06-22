package com.renatojobal.libraryutpl.mainactivity.fhome;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.AuthorModel;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;
import com.renatojobal.libraryutpl.repository.webservice.ApiClient;
import com.renatojobal.libraryutpl.repository.webservice.GeneralCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;

/**
 * This is a class that brings the recommended books from the server
 * and save them into the local database
 */
public class HomeContentPuller implements Runnable{



    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        Timber.i("Collecting recommended books");

        // Build the service
        RecommendsRetrofitInterface retrofitInterface = ApiClient.getClient().create(RecommendsRetrofitInterface.class);

        Call<List<BookInfoModel>> call = retrofitInterface.getRecommendedBooks();

        // Enqueue the call
        call.enqueue(new GeneralCallback<List<BookInfoModel>>(call) {
            @Override
            public void onFinalResponse(Call<List<BookInfoModel>> call, Response<List<BookInfoModel>> response) {

                // Save the response into database, in this way the live data of main view model could know about it

                RoomHelper.getAppDatabaseInstance().bookInfoDao().insertAllOrReplace(response.body());



            }
        });




    }


}
