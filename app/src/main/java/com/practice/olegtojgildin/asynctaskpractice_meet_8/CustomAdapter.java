package com.practice.olegtojgildin.asynctaskpractice_meet_8;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by olegtojgildin on 12/01/2019.
 */

public class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.ViewHolderWorker>  {
    private List<Worker> workers;


    public CustomAdapter(List<Worker> workersList) {
        workers=workersList;
    }

    @NonNull
    @Override
    public ViewHolderWorker onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work, parent, false);
            return new ViewHolderWorker(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderWorker holder, int i) {
            initLayout( holder, i);
    }

    public void initLayout(ViewHolderWorker holder, int i) {
        holder.name.setText("Name: " + workers.get(i).getName());
        holder.age.setText("Age: " + workers.get(i).getAge());
        holder.position.setText("Position: " + workers.get(i).getPosition());
        holder.photo.setImageResource(workers.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return workers.size();
    }


    public static class ViewHolderWorker extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView age;
        public TextView position;
        public ImageView photo;

        public ViewHolderWorker(View v) {
            super(v);
            name = v.findViewById(R.id.name);
            age = v.findViewById(R.id.age);
            position = v.findViewById(R.id.position);
            photo = v.findViewById(R.id.photo);

        }
    }

}
