package com.samsung.barracudapff.fragmentexample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.samsung.barracudapff.fragmentexample.fragments.ChatFragment;
import com.samsung.barracudapff.fragmentexample.fragments.HomeFragment;
import com.samsung.barracudapff.fragmentexample.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        switchFragment(new HomeFragment());
                        break;
                    case R.id.chat:
                        switchFragment(new ChatFragment());
                        break;
                    case R.id.settings:
                        switchFragment(new SettingsFragment());
                        break;
                }
                return false;
            }
        });
    }

    private void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
