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

public class MyAsyncTask extends AsyncTask<Void,Void,Void> {
    public static final int MESSAGE_ID=1;
    private Random rnd;
    private Handler mHandler;

    public MyAsyncTask(Handler handler){
        rnd=new Random();
        mHandler=handler;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        while (!isCancelled()) {
            try {
               Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(MESSAGE_ID, rnd.nextInt(100));
            message.sendToTarget();
        }
        return null;g
    }


}
