package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by olegtojgildin on 12/01/2019.
 */

public class MyAsyncTask extends AsyncTask<Void,Void,Integer> {
    @Override
    protected Integer doInBackground(Void... voids) {
        Random rnd=new Random();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rnd.nextInt();
    }


}
