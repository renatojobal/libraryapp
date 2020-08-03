package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

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
 * Manager between the view model and the repository
 */
public class SearchBookPresenter {


    /**
     * Search a book and storage into database
     */
    public void searchBook(String query) {

        deletePreviousResult();

        SearchBookBody searchBookBody = new SearchBookBody();
        searchBookBody.setTitle(query);
        SearchBookRetrofitInterface searchBookRetrofitInterface =
                ApiClient.getClient().create(SearchBookRetrofitInterface.class);
        Call<List<SearchResponse>> call = searchBookRetrofitInterface.searchBookByTitle(searchBookBody);

        call.enqueue(new GeneralCallback<List<SearchResponse>>(call) {
            @Override
            public void onFinalResponse(Call<List<SearchResponse>> call, Response<List<SearchResponse>> response) {
                Timber.d("onFinalResponse: %s", response.body());
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        for (int i = 0; i < response.body().size(); i++) {
                            Timber.i("Element result: %s", response.body().get(i));
                            // Getting each element and save it into data base
                            SearchResponse searchResponse = response.body().get(i);
                            Timber.i("Saving response into database ");
                            saveResultIntoDatabase(searchResponse);


                        }
                    }
                }).start();
            }
        });


    }


    /**
     * Saving the result into database
     * ? It could be improved
     *
     * @param searchResponse response
     */
    public void saveResultIntoDatabase(SearchResponse searchResponse) {

        SampleBookModel sampleBookModel = searchResponse.getSingularBookInfo();
        BookInfoModel bookInfoModel = searchResponse.getBookInfo();
        AuthorModel authorModel = searchResponse.getAuthorsInfo();
        ShelfModel actualShelf = searchResponse.getActualShelf();


        if (authorModel != null) {
            RoomHelper.getAppDatabaseInstance().authorDao().insertOrReplace(searchResponse.getAuthorsInfo());
        }

        if (bookInfoModel != null) {
            RoomHelper.getAppDatabaseInstance().bookInfoDao().insertOrReplace(bookInfoModel);
        }

        if (actualShelf != null) {
            RoomHelper.getAppDatabaseInstance().shelfDao().insertOrReplace(actualShelf);
        }

        if (sampleBookModel != null) {
            RoomHelper.getAppDatabaseInstance().sampleBookDao().insertOrReplace(sampleBookModel);
        }


    }

    /**
     * Delete previous database result,
     * We do that for not showing previous result in the screen
     */
    public void deletePreviousResult() {
        new Thread(() -> {
            RoomHelper.getAppDatabaseInstance().bookInfoDao().deleteAll();
            RoomHelper.getAppDatabaseInstance().authorDao().deleteAll();
            RoomHelper.getAppDatabaseInstance().shelfDao().deleteAll();
            RoomHelper.getAppDatabaseInstance().sampleBookDao().deleteAll();
        }).start();
    }
}
