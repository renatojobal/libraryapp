package com.renatojobal.libraryutpl.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ActivityMainBinding;

import timber.log.Timber;


public class MainActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState
     */

    ActivityMainBinding binding;
    MainViewModel mainViewModel;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);                                                  // Showing the splash screen for until the activity is ready
        super.onCreate(savedInstanceState);

        // Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // View model
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);


        setUpBinding();
        setUpUi();
        setTheme(R.style.AppTheme); // Change the them when the activity is ready
    }

    private void setUpBinding() {
        /** Bind the data */
        binding.setMainViewModel(mainViewModel);

    }



    private void setUpUi() {
        /** Set up the navigation system */
        navController = ((NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment))
                .getNavController();

        mainViewModel.getNewDestination().observe(this, new EventObserver<>(new EventListener<Integer>() {
            @Override public void onEvent(Integer destinationId) {
                Timber.d("New destination: ");
                navigate(destinationId);
            }
        }));
    }

    private void navigate(int destId) {
        navController.navigate(destId);
    }


}
