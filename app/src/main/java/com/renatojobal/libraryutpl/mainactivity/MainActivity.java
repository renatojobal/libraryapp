package com.renatojobal.libraryutpl.mainactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.renatojobal.libraryutpl.R;
import com.renatojobal.libraryutpl.databinding.ActivityMainBinding;
import com.renatojobal.libraryutpl.mainactivity.util.EventListener;
import com.renatojobal.libraryutpl.mainactivity.util.EventObserver;

import timber.log.Timber;

/**
 * MainActivity
 * We are following the single activity advice from android developers
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    ActivityMainBinding binding;
    MainViewModel mainViewModel;
    private NavController navController;


    /**
     * Method called when the activity is going to be created5
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);            // Showing the splash screen for until the activity is ready
        super.onCreate(savedInstanceState);

        // Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // View model
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);


        setUpBinding();
        setUpUi();
        setTheme(R.style.AppTheme); // Change the them when the activity is ready
    }

    /**
     * Bind the data
     */
    private void setUpBinding() {
        binding.setMainViewModel(mainViewModel);

    }

    /**
     * Set up the navigation system
     */
    private void setUpUi() {


        NavigationView drawerNavigationView = (NavigationView) findViewById(R.id.nav_view);


        // For control the side drawer onNavigationItemSelected
        drawerNavigationView.setNavigationItemSelectedListener(this);


        // Open or close the side menu
        ImageButton menuRight = findViewById(R.id.image_button_side_menu);
        menuRight.setOnClickListener(v -> {

            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle(null);

        getSupportActionBar().show();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

    }

    /**
     * We finally navigate to the specified destination
     * @param destId resource layout id
     */
    private void navigate(int destId) {
        navController.navigate(destId);
    }



    /**
     * Drawer Item selected logic
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                navController.navigate(R.id.homeFragment);
                break;

            case R.id.nav_inventary:
                navController.navigate(R.id.listFragment);
                break;

            case R.id.nav_loans:
                navController.navigate(R.id.loanFragment);
                break;

            case R.id.nav_notifications:
                navController.navigate(R.id.notificationFragment);
                break;
        }
        return true;
    }
}
