package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

/**
 * Created by olegtojgildin on 12/01/2019.
 */

public class SecondFragment extends Fragment {
    TextView result;
    public static SecondFragment newInstance() {
        
        Bundle args = new Bundle();
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.second_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        result=view.findViewById(R.id.number);


    }


    @Override
    public void onResume() {
        super.onResume();
        try {
            for (int i=0;i<10;i++)
            result.setText(Integer.toString(new MyAsyncTask().execute().get()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
