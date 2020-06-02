package com.renatojobal.libraryutpl.mainactivity.fhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    /**
     * Fragment home
     */

    // Fragment view-model
    HomeViewModel homeViewModel;

    // Using data binding
    FragmentHomeBinding homeBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        /**
         * onCreate
         * - Link the home view-model
         */
        super.onCreate(savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * onCreateView
         */
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);



        // Return the binding root
        return homeBinding.getRoot();
    }
}
