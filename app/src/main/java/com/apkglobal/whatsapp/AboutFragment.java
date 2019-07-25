package com.apkglobal.whatsapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        recyclerView = v.findViewById(R.id.recyclerview);
        //to fixed the recyclerview view size
        recyclerView.setHasFixedSize(true);
        //to set the default animation on item click
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //to take linear type of recyclerview
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));
        //to call the data from Adapter
        MyAdapter myAdapter = new MyAdapter();
        //to attach the data from myadapter to recyclerview
        recyclerView.setAdapter(myAdapter);
        return v;
    }

    private class MyAdapter extends RecyclerView.Adapter<Myholder> {
        List<Item> list;

        public MyAdapter() {
            list = new ArrayList<>();
            list.add(new Item(R.mipmap.ic_launcher, "Android", "IOS"));
            list.add(new Item(R.mipmap.ic_launcher, "Web", "IOS"));
            list.add(new Item(R.mipmap.ic_launcher, "App", "IOS"));
            list.add(new Item(R.mipmap.ic_launcher, "Mobile", "IOS"));
            list.add(new Item(R.mipmap.ic_launcher, "IOS", "IOS"));
        }

        @NonNull
        @Override
        public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup,
                                           int i) {
            //to attach the item xml to recyclerview adapter
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item, null);
            //to pass the item view to myholder class
            Myholder myholder = new Myholder(view);
            return myholder;
        }
        @Override
        public void onBindViewHolder(@NonNull Myholder myholder,
                                     int i) {
            //to pass all data into item class
                Item item=list.get(i);
                //to show the image from item class
                myholder.imageView.setImageResource(item.getImage());
                myholder.text1.setText(item.getText1());
                myholder.text2.setText(item.getText2());

        }
        @Override
        public int getItemCount() {
         //to return the arraylist data size
            return list.size();
        }
    }

    private class Myholder extends RecyclerView.ViewHolder {
        TextView text1, text2;
        ImageView imageView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
        imageView=itemView.findViewById(R.id.iv);
        text1=itemView.findViewById(R.id.text1);
        text2=itemView.findViewById(R.id.text2);
        }
    }
}
