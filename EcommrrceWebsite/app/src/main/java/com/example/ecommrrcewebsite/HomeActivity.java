package com.example.ecommrrcewebsite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.ecommrrcewebsite.Adapters.CatAdapter;
import com.example.ecommrrcewebsite.Fragments.CheckOutFragment;
import com.example.ecommrrcewebsite.Fragments.MoneyFragment;
import com.example.ecommrrcewebsite.Fragments.OrderFragment;
import com.example.ecommrrcewebsite.Fragments.videosFragment;
import com.example.ecommrrcewebsite.Models.CategoryModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //////changing color of status bar/////
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        /////////////

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigation);

        ///////replacing by default fragment on home activity ////////
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                new OrderFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigation =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId())
                    {
                        case R.id.orders:
                            selectedFragment = new OrderFragment();
                            break;

                        case R.id.checkout:
                            selectedFragment = new CheckOutFragment();
                            break;

                        case R.id.money:
                            selectedFragment = new MoneyFragment();
                            break;
                        case R.id.videos:
                            selectedFragment = new videosFragment();
                            break;
                    }

                    ///////replacing by default fragment on home activity ////////
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                            selectedFragment ).commit();
                    return true;
                }
            };
}