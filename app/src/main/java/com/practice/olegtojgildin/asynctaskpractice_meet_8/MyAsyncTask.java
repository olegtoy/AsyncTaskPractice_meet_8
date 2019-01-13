package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by olegtojgildin on 12/01/2019.
 */

public class MyAsyncTask extends AsyncTask<Void,Void,Integer> {
    private Random rnd;

    public MyAsyncTask(){
        rnd=new Random();
    }
    @Override
    protected Integer doInBackground(Void... voids) {
            try {
               Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return rnd.nextInt(100);
    }


}
