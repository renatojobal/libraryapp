package com.renatojobal.libraryutpl.mainactivity.fdetailedbook;

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

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.FragmentHomeBinding;
import com.renatojobal.libraryutpl.databinding.FragmentSearchBookBinding;
import com.renatojobal.libraryutpl.mainactivity.MainViewModel;
import com.renatojobal.libraryutpl.mainactivity.fhome.HomeViewModel;
import com.renatojobal.libraryutpl.mainactivity.fhome.ui.RootRecyclerViewAdapter;
import com.renatojobal.libraryutpl.repository.localdatabase.RoomHelper;
import com.renatojobal.libraryutpl.repository.model.BookInfoModel;

public class DetailedBookFragment extends Fragment {


    // Main vie-model
    MainViewModel mainViewModel;

    // Using data binding
    FragmentSearchBookBinding binding;


    /**
     * onCreate
     * - Link the main view-model
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);

        // Get info about the focused book and show on the screen
        setUpElements();
    }

    /**
     * Get info about the focused book available on the main view model and show on the screen
     */
    private void setUpElements() {
        mainViewModel.getFocusBookId().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(integer != null){
                            BookInfoModel bookInfoModel = RoomHelper.getAppDatabaseInstance().bookInfoDao().getBookInfo(integer);



                        }
                    }
                }).start();
            }
        });
    }


    /**
     * Called to have the fragment instantiate its user interface view.
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detailed_book, container, false);

        return binding.getRoot();
    }
}
