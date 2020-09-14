package com.renatojobal.libraryutpl.mainactivity.finventory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

import java.util.List;

import timber.log.Timber;

public class InventoryViewModel extends ViewModel {


    // To show the shelfs on the spinner
    private MutableLiveData<List<ShelfModel>> shelfs = new MutableLiveData<>();

    // To show the books on the spinner
    private MutableLiveData<List<BookInfoModel>> books = new MutableLiveData<>();

    // TO show the singular books on the list
    private MutableLiveData<List<DetailedResponse>> singular_books = new MutableLiveData<>();

    // Presenter instance
    private InventoryPresenter inventoryPresenter;

    /**
     * Empty constructor
     */
    public InventoryViewModel() {
        inventoryPresenter = new InventoryPresenter();

        inventoryPresenter.loadDataToAddBook(shelfs, books);

        inventoryPresenter.loadSingularBooks(singular_books);
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

    public LiveData<List<DetailedResponse>> getDetailedSingularBooks(){
        return this.singular_books;
    }

    /**
     * Method to save the book on the server
     */
    public void saveBookOnTheServer(SampleBookModel targetBook) {
        inventoryPresenter.saveBookOnServer(targetBook);
    }




}
