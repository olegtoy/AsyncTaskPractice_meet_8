package com.practice.olegtojgildin.asynctaskpractice_meet_8;

/**
 * Created by olegtojgildin on 12/01/2019.
 */

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WorkerGenerator extends Thread {
    public static final int MESSAGE_ID_ADD = 1;
    private static List<String> femaleNames = new ArrayList<>(Arrays.asList("Anna", "Emma", "Sophie", "Jessica", "Scarlett", "Molly", "Lucy", "Megan"));
    private static List<String> surnames = new ArrayList<>(Arrays.asList("Green", "Smith", "Taylor", "Brown", "Wilson", "Walker", "White", "Jackson", "Wood"));
    private static List<String> positions = new ArrayList<>(Arrays.asList("Android programmer", "iOs programmer", "Web programmer", "Designer"));

    public static Worker generateWorker() {
        Worker worker = new Worker();
        Random randomGenerator = new Random();
        String randomName = femaleNames.get(randomGenerator.nextInt(femaleNames.size()));
        String randomSurname = surnames.get(randomGenerator.nextInt(surnames.size()));
        worker.setName(randomName + " " + randomSurname);
        worker.setPhoto(R.drawable.ic_male_black);
        worker.setAge(Integer.toString(20 + randomGenerator.nextInt(10)));
        worker.setPosition(positions.get(randomGenerator.nextInt(positions.size())));
        return worker;
    }

    private Handler mHandler;

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(MESSAGE_ID_ADD, generateWorker());
            message.sendToTarget();
        }
    }

    public WorkerGenerator(Handler handler) {
        mHandler = handler;

    }
}