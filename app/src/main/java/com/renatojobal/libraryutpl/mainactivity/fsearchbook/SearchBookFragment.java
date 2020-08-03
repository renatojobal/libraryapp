package com.renatojobal.libraryutpl.mainactivity.fsearchbook;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.renatojobal.libraryutpl.R;

import com.renatojobal.libraryutpl.databinding.FragmentSearchBookBinding;
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui.SamplesBookLiveDataListAdapter;

import java.util.List;

import timber.log.Timber;

/**
 * Fragment search book
 */
public class SearchBookFragment extends Fragment {

    private SearchBookViewModel searchBookViewModel;        // Fragment view model

    FragmentSearchBookBinding fragmentSearchBookBinding;    // Binding element

    // UI elements (Could use dagger for injection in the future)
    private SamplesBookLiveDataListAdapter resultBookLiveDataListAdapter;


    /**
     * Link the view model
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        searchBookViewModel = new ViewModelProvider(this).get(SearchBookViewModel.class);

        Timber.d("onCreate: Create search book fragment");
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentSearchBookBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_book, container, false);

        resultBookLiveDataListAdapter = new SamplesBookLiveDataListAdapter(searchBookViewModel.getResultBookFullList());
        fragmentSearchBookBinding.recyclerViewResultList.setLayoutManager(new LinearLayoutManager(getContext()));

        searchBookViewModel.getResultBookFullList().observe(getViewLifecycleOwner(), new Observer<List<BookFull>>() {
            @Override
            public void onChanged(List<BookFull> resultViews) {
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
         // Change Live Data into the observer if needed
        super.onViewCreated(view, savedInstanceState);

    }
}
