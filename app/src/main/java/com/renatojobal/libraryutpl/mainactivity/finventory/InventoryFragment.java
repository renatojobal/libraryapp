package com.renatojobal.libraryutpl.mainactivity.finventory;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentInventaryBinding;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;
import com.renatojobal.libraryutpl.repository.model.ShelfModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {

    // Using data binding
    FragmentInventaryBinding binding;

    // View model
    InventoryViewModel inventoryViewModel;

    // Spinners adapters
    private ArrayAdapter<ShelfModel> shelfModelArrayAdapter;
    private ArrayAdapter<BookInfoModel> bookInfoModelArrayAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inventoryViewModel = new ViewModelProvider(this).get(InventoryViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_inventary, container, false);

        // Set up the spinner information inside
        setUpSpinners();

        return binding.getRoot();
    }

    /**
     * Method to set listener to view model info
     */
    private void setUpSpinners() {
        inventoryViewModel.getShelfs().observe(getViewLifecycleOwner(), shelfModels -> {
            if(shelfModels!= null && !shelfModels.isEmpty()){
                shelfModelArrayAdapter = new ArrayAdapter<ShelfModel>(getContext(),
                        R.layout.item_spinner,
                        R.id.item_spinner_text,
                        shelfModels);

                binding.spinnerShelfs.setAdapter(shelfModelArrayAdapter);
            }
        });

        inventoryViewModel.getBooks().observe(getViewLifecycleOwner(), bookInfoModelList -> {
            if(bookInfoModelList!= null && !bookInfoModelList.isEmpty()){
                bookInfoModelArrayAdapter = new ArrayAdapter<BookInfoModel>(getContext(),
                        R.layout.item_spinner,
                        R.id.item_spinner_text,
                        bookInfoModelList);

                binding.spinnerBooks.setAdapter(bookInfoModelArrayAdapter);
            }
        });
    }
}