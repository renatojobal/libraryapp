package com.renatojobal.libraryutpl.mainactivity.fdetailedmap;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentDetailedMapBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedMapFragment extends Fragment {


    // Using data binding
    FragmentDetailedMapBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detailed_map, container, false);


        DetailedMapFragmentArgs arguments = DetailedMapFragmentArgs.fromBundle(getArguments());

        binding.mapSection.setText(arguments.getSection());
        binding.mapShelf.setText(arguments.getShelf());




        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}