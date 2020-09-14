package com.renatojobal.libraryutpl.mainactivity.finventory;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentListSingularBooksBinding;
import com.renatojobal.libraryutpl.mainactivity.util.DetailedResponse;

import java.util.List;

public class ListFragment extends Fragment {

    // Using data binding
    FragmentListSingularBooksBinding binding;

    // View model
    InventoryViewModel inventoryViewModel;

    // Adapter
    SingularBookAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inventoryViewModel = new ViewModelProvider(this).get(InventoryViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_singular_books, container, false);

        // Set up the spinner information inside
        setUpList();

        // Set up the button functionality
        setUpButton();


        return binding.getRoot();
    }

    /**
     * Go the add book fragment
     */
    private void setUpButton() {

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(binding.getRoot()).navigate(R.id.inventaryFragment);
            }
        });


    }

    /**
     * Method to load all the singular books
     */
    private void setUpList() {
        adapter = new SingularBookAdapter(inventoryViewModel.getDetailedSingularBooks());

        binding.recyclerViewSingularBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        inventoryViewModel.getDetailedSingularBooks().observe(getViewLifecycleOwner(), detailedResponses -> {

            if(detailedResponses == null || detailedResponses.isEmpty()){
                binding.recyclerViewSingularBooks.setVisibility(View.GONE);
            }else {
                binding.recyclerViewSingularBooks.setVisibility(View.VISIBLE);
                binding.recyclerViewSingularBooks.setAdapter(adapter);
            }


        });
    }





}
