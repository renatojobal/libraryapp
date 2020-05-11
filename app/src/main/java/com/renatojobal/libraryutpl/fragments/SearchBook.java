package com.renatojobal.libraryutpl.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renatojobal.libraryutpl.R;

public class SearchBook extends Fragment {
    /**
     * SearchBook fragment
     */

    private SearchBookViewModel mViewModel;

    public static SearchBook newInstance() {
        return new SearchBook();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_book_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SearchBookViewModel.class);
        // TODO: Use the ViewModel
    }

}
