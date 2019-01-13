package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olegtojgildin on 12/01/2019.
 */

public class ThirdFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mManager;
    private List<Worker> mWorkerList;
    WorkerGenerator generator;

    public static ThirdFragment newInstance() {
        Bundle args = new Bundle();
        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWorkerList = new ArrayList<>();
        generator = new WorkerGenerator(mHandler);
        generator.start();
    }

    public void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.recyclerview);
        mManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);
        mAdapter = new CustomAdapter(mWorkerList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case WorkerGenerator.MESSAGE_ID_ADD:
                    mWorkerList.add((Worker) message.obj);
                    mRecyclerView.setAdapter(new CustomAdapter(mWorkerList));
                    break;

                default:
                    super.handleMessage(message);
            }
        }
    };
}
