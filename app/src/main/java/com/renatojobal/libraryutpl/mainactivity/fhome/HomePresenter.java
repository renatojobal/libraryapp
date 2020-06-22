package com.renatojobal.libraryutpl.mainactivity.fhome;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.BookFull;
import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * This class will help for processing some data
 */
public class HomePresenter {


    public void getRecommendedBook(MutableLiveData<List<List<BookInfoModel>>> targetRecommendedList){

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<BookInfoModel> singleList = RoomHelper.getAppDatabaseInstance().recommendBooksDao().singleResultList();

                List<List<BookInfoModel>> recommendedBooks = new ArrayList<>();
                for (int i = 0; i < 6; i ++){
                    recommendedBooks.add(singleList);

                }


                targetRecommendedList.postValue(recommendedBooks);
            }
        }
        ).run();



    }


    /**
     * Brings the recommended book from the server
     */
    public void pullHomeContent(){

        new Thread(new HomeContentPuller()).start();
    }






}
