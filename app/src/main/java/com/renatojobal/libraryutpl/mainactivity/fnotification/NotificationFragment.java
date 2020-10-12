package com.renatojobal.libraryutpl.mainactivity.fnotification;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentLoanBinding;
import com.renatojobal.libraryutpl.databinding.FragmentNotificationBinding;
import com.renatojobal.libraryutpl.mainactivity.floan.LoanAdapter;
import com.renatojobal.libraryutpl.mainactivity.floan.LoanViewModel;

import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {


    // Using data binding
    FragmentNotificationBinding binding;

    // Reference to the view model
    NotificationViewModel notificationViewModel;

    // Adapter
    NotificationAdapter notificationAdapter;

    // Filters
    Boolean notReturned = true;
    Boolean incorrectPosition = true;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notificationViewModel = new ViewModelProvider(this).get(NotificationViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false);


        // Set up the recycler view
        setUpNotifications();


        binding.switchNotReturned.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                notReturned = isChecked;
                notificationAdapter = new NotificationAdapter(notificationViewModel.getNotifications(),
                        notReturned, incorrectPosition);
                binding.recyclerViewNotifications.setAdapter(null);
                binding.recyclerViewNotifications.setLayoutManager(null);
                binding.recyclerViewNotifications.setAdapter(notificationAdapter);
                binding.recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(getContext()));
                notificationAdapter.notifyDataSetChanged();
            }
        });

        binding.switchIncorrectPosition.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                incorrectPosition = isChecked;
                notificationAdapter = new NotificationAdapter(notificationViewModel.getNotifications(),
                        notReturned, incorrectPosition);
                binding.recyclerViewNotifications.setAdapter(null);
                binding.recyclerViewNotifications.setLayoutManager(null);
                binding.recyclerViewNotifications.setAdapter(notificationAdapter);
                binding.recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(getContext()));
                notificationAdapter.notifyDataSetChanged();
            }
        });


        return binding.getRoot();
    }

    private void setUpNotifications() {
        notificationAdapter = new NotificationAdapter(notificationViewModel.getNotifications(),
                notReturned, incorrectPosition);

        binding.recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(getContext()));

        notificationViewModel.getNotifications().observe(getViewLifecycleOwner(), detailedResponses -> {


            if (detailedResponses.isEmpty()) {
                Timber.d("List result is empty");
                // If the list is empty
                binding.recyclerViewNotifications.setVisibility(View.GONE);

            } else {
                Timber.d("List result is not empty");
                // If is  not empty
                binding.recyclerViewNotifications.setVisibility(View.VISIBLE);
                binding.recyclerViewNotifications.setAdapter(notificationAdapter);
            }

        });
    }



}