package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
    MyAsyncTask myAsyncTask;

    public static SecondFragment newInstance() {
        Bundle args = new Bundle();
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MyAsyncTask.MESSAGE_ID:
                    result.setText(Integer.toString((Integer) msg.obj));
                default:
                    super.handleMessage(msg);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        result = view.findViewById(R.id.number);
    }

    @Override
    public void onResume() {
        super.onResume();
        myAsyncTask=new MyAsyncTask(mHandler);
        myAsyncTask.execute();
    }

    @Override
    public void onPause() {
        super.onPause();
        myAsyncTask.cancel(true);
    }
}
