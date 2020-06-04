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
import androidx.navigation.ActionOnlyNavDirections;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentHomeBinding;
import com.renatojobal.libraryutpl.mainactivity.MainViewModel;
import com.renatojobal.libraryutpl.mainactivity.fhome.ui.RootRecyclerViewAdapter;


public class HomeFragment extends Fragment {
    /**
     * Fragment home
     */

    // Fragment view-model
    HomeViewModel homeViewModel;

    // Main vie-model
    MainViewModel mainViewModel;

    // Using data binding
    FragmentHomeBinding binding;

    // Adapters
    RootRecyclerViewAdapter rootRecyclerViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        /**
         * onCreate
         * - Link the home view-model
         */
        super.onCreate(savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * onCreateView
         */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setUpBindingData();

        // Create the root adapter
        // TODO: Set up the adapters
        rootRecyclerViewAdapter = new RootRecyclerViewAdapter();




        // Return the binding root
        return binding.getRoot();
    }

    private void setUpBindingData(){
        binding.setMainViewModel(mainViewModel);
        binding.setHomeViewModel(homeViewModel);
        setUpNavigation();
    }


    private void setUpNavigation(){
        binding.setNavDirection(HomeFragmentDirections.actionHomeFragmentToSearchBookFragment());

    }




}
