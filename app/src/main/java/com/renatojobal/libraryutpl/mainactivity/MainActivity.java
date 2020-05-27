package com.renatojobal.libraryutpl.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState
     */

    ActivityMainBinding binding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);                                                  // Showing the splash screen for until the activity is ready
        super.onCreate(savedInstanceState);

        // Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // View model
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);



    }
}
