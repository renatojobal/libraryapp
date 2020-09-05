package com.renatojobal.libraryutpl.mainactivity.finventory;

import androidx.lifecycle.MutableLiveData;

import com.renatojobal.libraryutpl.mainactivity.fsearchbook.SearchBookBody;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.SearchBookRetrofitInterface;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.response.SearchResponse;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;
import com.renatojobal.libraryutpl.repository.webservice.ApiClient;
import com.renatojobal.libraryutpl.repository.webservice.GeneralCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class InventoryPresenter {


    /**
     * Method that populate the list with data from the database
     * @param shelfs
     * @param books
     */
    public void loadDataToAddBook(MutableLiveData<List<ShelfModel>> shelfs, MutableLiveData<List<BookInfoModel>> books) {



        InventoryRetrofitInterface retrofitInterface = ApiClient.getClient().create(InventoryRetrofitInterface.class);

        Call<List<ShelfModel>> shelfsCall = retrofitInterface.pullShelfs();

        shelfsCall.enqueue(new GeneralCallback<List<ShelfModel>>(shelfsCall) {
            @Override
            public void onFinalResponse(Call<List<ShelfModel>> call, Response<List<ShelfModel>> response) {

                // Populate the mutable variable
                shelfs.postValue(response.body());
            }
        });

        Call<List<BookInfoModel>> booksCall = retrofitInterface.pullBooks();

        booksCall.enqueue(new GeneralCallback<List<BookInfoModel>>(booksCall) {
            @Override
            public void onFinalResponse(Call<List<BookInfoModel>> call, Response<List<BookInfoModel>> response) {

                // Populate the mutable variable
                books.postValue(response.body());
            }
        });



    }
}
