package com.renatojobal.libraryutpl.mainactivity.fsearchbook.ui;

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
import com.renatojobal.libraryutpl.mainactivity.fsearchbook.SearchBookViewModel;
import com.renatojobal.libraryutpl.repository.model.SampleBookModel;

import java.util.List;

public class SearchBookFragment extends Fragment {
    /**
     * SearchBook fragment
     */
    private static final String TAG = "SearchBookFragment";

    private SearchBookViewModel searchBookViewModel;

    FragmentSearchBookBinding binding;

    // UI elements (Could use dagger for injection in hte future)
    private RecyclerView resultRecyclerView;
    private SamplesBookLiveDataListAdapter samplesBookLiveDataListAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        /**
         * Link the view model
         */
        super.onCreate(savedInstanceState);
        searchBookViewModel = new ViewModelProvider(this).get(SearchBookViewModel.class);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search_book, container, false);

        samplesBookLiveDataListAdapter = new SamplesBookLiveDataListAdapter(getContext(), searchBookViewModel.getSampleBookResultList());
        binding.recyclerViewResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        searchBookViewModel.getSampleBookResultList().observe(getViewLifecycleOwner(), new Observer<List<SampleBookModel>>() {
            @Override
            public void onChanged(List<SampleBookModel> sampleBookModelList) {
                binding.recyclerViewResultList.setAdapter(samplesBookLiveDataListAdapter);
            }
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i(TAG, "Query: "+query);
                searchBookViewModel.setTargetBook(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // We don't care about this for the moment
                return false;
            }
        });




        return binding.getRoot();


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
