package com.renatojobal.libraryutpl.mainactivity.floan;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentLoanBinding;
import com.renatojobal.libraryutpl.repository.model.InternalLoan;

import java.util.List;

import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoanFragment extends Fragment {


    // Using data binding
    FragmentLoanBinding binding;

    // Reference to the view model
    LoanViewModel loanViewModel;

    // Adapter
    LoanAdapter loanAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loanViewModel = new ViewModelProvider(this).get(LoanViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_loan, container, false);


        // Set up the recycler view
        setUpInternalLoans();

        return binding.getRoot();
    }

    /**
     * Method to attach a listener from the view model and show the result on the screen
     */
    private void setUpInternalLoans() {

        loanAdapter = new LoanAdapter(loanViewModel.getInternalLoans());

        binding.recyclerViewLoans.setLayoutManager(new LinearLayoutManager(getContext()));

        loanViewModel.getInternalLoans().observe(getViewLifecycleOwner(), internalLoans -> {


            if (internalLoans.isEmpty()) {
                Timber.d("List result is empty");
                // If the list is empty
                binding.recyclerViewLoans.setVisibility(View.GONE);

            } else {
                Timber.d("List result is not empty");
                // If is  not empty
                binding.recyclerViewLoans.setVisibility(View.VISIBLE);
                binding.recyclerViewLoans.setAdapter(loanAdapter);
            }

        });


    }

}