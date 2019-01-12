package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }
    public void initFragment(){
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.container1,FirstFragment.newInstance(),"firstFragment")
                .add(R.id.container2_1,SecondFragment.newInstance())
                .add(R.id.container2_2,ThirdFragment.newInstance())
                .commit();

    }
}
