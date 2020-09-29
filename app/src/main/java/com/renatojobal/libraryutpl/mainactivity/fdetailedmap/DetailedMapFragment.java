package com.renatojobal.libraryutpl.mainactivity.fdetailedmap;

import android.os.Bundle;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_map, container, false);
    }
}