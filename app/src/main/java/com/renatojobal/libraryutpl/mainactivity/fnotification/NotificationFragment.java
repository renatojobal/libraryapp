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
import com.renatojobal.libraryutpl.databinding.FragmentNotificationBinding;

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

                notificationViewModel.updateFilteredNotifications(notReturned, incorrectPosition);
            }
        });

        binding.switchIncorrectPosition.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                incorrectPosition = isChecked;

                notificationViewModel.updateFilteredNotifications(notReturned, incorrectPosition);
            }
        });


        return binding.getRoot();
    }

    private void setUpNotifications() {


        binding.recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(getContext()));

        notificationViewModel.getFilteredNotifications().observe(getViewLifecycleOwner(), detailedResponses -> {


            if (detailedResponses.isEmpty()) {
                Timber.d("List result is empty");
                // If the list is empty
                binding.recyclerViewNotifications.setVisibility(View.GONE);

            } else {
                Timber.d("List result is not empty");
                notificationAdapter = new NotificationAdapter(notificationViewModel.getFilteredNotifications().getValue());
                Timber.d(notificationViewModel.getFilteredNotifications().getValue()+"");
                // If is  not empty

                binding.switchIncorrectPosition.setEnabled(true);
                binding.switchNotReturned.setEnabled(true);

                binding.recyclerViewNotifications.setVisibility(View.VISIBLE);
                binding.recyclerViewNotifications.setAdapter(notificationAdapter);
            }

        });
    }



}