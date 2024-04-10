package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void returnHome(View view) {



        Fragment fragment = new HomeFragment();
        FragmentManager fm = getSupportFragmentManager();

        Fragment currentFragment = fm.findFragmentById(R.id.fragmentContainerView);

        //Only executes when not already on home screen
        if(currentFragment instanceof HomeFragment ){
            return;
        }else{
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment).commit();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}