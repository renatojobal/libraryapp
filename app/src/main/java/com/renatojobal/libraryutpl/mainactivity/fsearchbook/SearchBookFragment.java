package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.renatojobal.libraryutpl.R;

import com.renatojobal.libraryutpl.databinding.FragmentSearchBookBinding;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.ResultView;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.SearchBookViewModel;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui.SamplesBookLiveDataListAdapter;

import java.util.List;

import timber.log.Timber;


public class SearchBookFragment extends Fragment {
    /**
     * Fragment search book
     */


    private SearchBookViewModel searchBookViewModel;        // Fragment view model

    FragmentSearchBookBinding fragmentSearchBookBinding;    // Binding element

    // UI elements (Could use dagger for injection in the future)
    private SamplesBookLiveDataListAdapter resultBookLiveDataListAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        /**
         * Link the view model
         */
        super.onCreate(savedInstanceState);
        searchBookViewModel = new ViewModelProvider(this).get(SearchBookViewModel.class);

        Timber.wtf("onCreate: Create search book fragment");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentSearchBookBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_book, container, false);

        resultBookLiveDataListAdapter = new SamplesBookLiveDataListAdapter(searchBookViewModel.getResultBookFullList());
        fragmentSearchBookBinding.recyclerViewResultList.setLayoutManager(new LinearLayoutManager(getContext()));

        searchBookViewModel.getResultBookFullList().observe(getViewLifecycleOwner(), new Observer<List<ResultView>>() {
            @Override
            public void onChanged(List<ResultView> resultViews) {
            // Change the result list now
            fragmentSearchBookBinding.recyclerViewResultList.setAdapter(resultBookLiveDataListAdapter);
            }
        });


        fragmentSearchBookBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Timber.i("Query: "+query);
                searchBookViewModel.setTargetBook(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // We don't care about this for the moment
                return false;
            }
        });




        return fragmentSearchBookBinding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        /**
         * Change Live Data into the observer.
         */
        super.onViewCreated(view, savedInstanceState);

        // Linking UI elements



    }
}
