package com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renatojobal.libraryutpl.R;

import com.renatojobal.libraryutpl.databinding.FragmentSearchBookBinding;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.SearchBookViewModel;

public class SearchBookFragment extends Fragment {
    /**
     * SearchBook fragment
     */

    private SearchBookViewModel searchBookViewModel;

    FragmentSearchBookBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_book, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchBookViewModel = new ViewModelProvider(this).get(SearchBookViewModel.class);




    }

}
