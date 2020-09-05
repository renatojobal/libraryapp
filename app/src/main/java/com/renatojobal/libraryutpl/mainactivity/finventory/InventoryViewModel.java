package com.renatojobal.libraryutpl.mainactivity.finventory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

import java.util.List;

public class InventoryViewModel extends ViewModel {


    // To show the shelfs on the spinner
    private MutableLiveData<List<ShelfModel>> shelfs = new MutableLiveData<>();

    // To show the books on the spinner
    private MutableLiveData<List<BookInfoModel>> books= new MutableLiveData<>();

    // Presenter instance
    private InventoryPresenter inventoryPresenter;

    /**
     * Empty constructor
     */
    public InventoryViewModel() {
        inventoryPresenter = new InventoryPresenter();

        inventoryPresenter.loadDataToAddBook(shelfs, books);
    }

    /**
     * Exposing data
     */
    public LiveData<List<ShelfModel>> getShelfs() {
        return shelfs;
    }

    public LiveData<List<BookInfoModel>> getBooks() {
        return books;
    }
}
