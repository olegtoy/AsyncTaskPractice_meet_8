package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;

import java.util.Random;

/**
 * Created by olegtojgildin on 12/01/2019.
 */

public class MyLoader extends AsyncTaskLoader<Integer> {
    public MyLoader(Context context, Bundle bundle){
        super(context);
    }


    @Override
    public Integer loadInBackground() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getRandomColour();
    }

    public Integer getRandomColour(){
        Random random=new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        return  color;
    }
}
