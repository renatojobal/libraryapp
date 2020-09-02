package com.renatojobal.libraryutpl.mainactivity.fmenu;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentMenuBinding;
import com.renatojobal.libraryutpl.mainactivity.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {


    // Using data binding
    FragmentMenuBinding binding;

    // Main view model
    MainViewModel mainViewModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get reference to the main view model
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false);



        // Returning the view
        return binding.getRoot();
    }
}