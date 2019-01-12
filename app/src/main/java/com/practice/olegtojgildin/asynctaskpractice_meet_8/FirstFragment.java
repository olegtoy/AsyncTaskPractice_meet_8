package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by olegtojgildin on 12/01/2019.
 */

public class FirstFragment extends Fragment implements LoaderManager.LoaderCallbacks<Integer>{

    public static final int LOADER_ID=1000;
    private Loader<Integer> mLoader;
    private Fragment fragment;
    private FragmentManager mFragmentManager;

    public static FirstFragment newInstance() {
        Bundle args = new Bundle();
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoader=getActivity().getSupportLoaderManager().initLoader(LOADER_ID,new Bundle(),this);
        mFragmentManager=getFragmentManager();
        fragment=mFragmentManager.findFragmentByTag("firstFragment");
        mLoader.forceLoad();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.first_fragment,container,false);
        return view;
    }

    @Override
    public Loader<Integer> onCreateLoader(int id, Bundle args) {
        Loader<Integer> mLoader=null;
        if(id==LOADER_ID)
            mLoader=new MyLoader(getContext(),args);
        return mLoader;
    }

    @Override
    public void onLoadFinished(Loader<Integer> loader, Integer data) {
        fragment.getView().setBackgroundColor(data);
        mLoader.forceLoad();
    }

    @Override
    public void onLoaderReset(Loader<Integer> loader) {

    }
}
