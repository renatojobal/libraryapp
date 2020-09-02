package com.renatojobal.libraryutpl.mainactivity.fhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentHomeBinding;
import com.renatojobal.libraryutpl.mainactivity.MainViewModel;
import com.renatojobal.libraryutpl.mainactivity.fhome.ui.RootRecyclerViewAdapter;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

import java.util.List;

import timber.log.Timber;


/**
 * Fragment home
 */
public class HomeFragment extends Fragment {


    // Fragment view-model
    HomeViewModel homeViewModel;

    // Main vie-model
    MainViewModel mainViewModel;

    // Using data binding
    FragmentHomeBinding binding;

    // Adapters
    RootRecyclerViewAdapter rootRecyclerViewAdapter;

    /**
     * onCreate
     * - Link the home view-model
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

    }


    /**
     * onCreateView
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setUpBindingData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rootRecyclerView.setLayoutManager(layoutManager);

        // Create the root adapter
        rootRecyclerViewAdapter = new RootRecyclerViewAdapter(getContext(), mainViewModel.getRecommendedBooks(),
                new RootRecyclerViewAdapter.ItemClickListener() {
                    @Override
                    public void onClickListener(View v, BookInfoModel bookInfoModel) {
                        Timber.d("Triggered the listener");
                        mainViewModel.setFocusBook(bookInfoModel);
                        Navigation.findNavController(v).navigate(R.id.detailedBookFragment);
                    }
                });
        mainViewModel.getRecommendedBooks().observe(getActivity(), new Observer<List<List<BookInfoModel>>>() {
            @Override
            public void onChanged(List<List<BookInfoModel>> lists) {
                if (!lists.isEmpty()) { // If the list is no empty
                    Timber.d("Setting the adapter");
                    binding.rootRecyclerView.setAdapter(rootRecyclerViewAdapter);
                }
            }
        });


        // Return the binding root
        return binding.getRoot();
    }

    private void setUpBindingData() {
        binding.setMainViewModel(mainViewModel);
        binding.setHomeViewModel(homeViewModel);
        setUpNavigation();
    }


    private void setUpNavigation() {
        binding.previousSearchView.setOnClickListener(v ->
                Navigation.findNavController(binding.getRoot()).navigate(R.id.searchBookFragment));

    }


}
