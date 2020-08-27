package com.renatojobal.libraryutpl.mainactivity.fhome;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.BookFull;
import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.webservice.ApiClient;
import com.renatojobal.libraryutpl.repository.webservice.GeneralCallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;

/**
 * This class will help for processing some data
 */
public class HomePresenter {


    /**
     * This method will access the data base in another thread
     * @param targetRecommendedList Live data observed by the view
     */
    public void getRecommendedBook(MutableLiveData<List<List<BookInfoModel>>> targetRecommendedList){

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<List<BookInfoModel>> recommendedBooks = new ArrayList<>();
                Timber.i("Collecting recommended books");

                // Build the service
                RecommendsRetrofitInterface retrofitInterface = ApiClient.getClient().create(RecommendsRetrofitInterface.class);

                Call<List<BookInfoModel>> call = retrofitInterface.getRecommendedBooks();

                // Enqueue the call
                call.enqueue(new GeneralCallback<List<BookInfoModel>>(call) {
                    @Override
                    public void onFinalResponse(Call<List<BookInfoModel>> call, Response<List<BookInfoModel>> response) {

                        // Save the response into database, in this way the live data of main view model could know about it
                        recommendedBooks.add(response.body());
                        targetRecommendedList.postValue(recommendedBooks);



                    }
                });



                targetRecommendedList.postValue(recommendedBooks);
            }
        }
        ).start();



    }






}
