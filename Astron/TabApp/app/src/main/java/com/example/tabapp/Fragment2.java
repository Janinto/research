package com.example.tabapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment2 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Activity activity = getActivity();
        Context context = getContext();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_2, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        MyMovieData[] myMovieData = new MyMovieData[]{
                new MyMovieData("Avengers","2019 film",R.drawable.avenger),
                new MyMovieData("Venom","2018 film",R.drawable.venom),
                new MyMovieData("Batman Begins","2005 film",R.drawable.batman),
                new MyMovieData("Jumanji","2019 film",R.drawable.jumanji),
                new MyMovieData("Good Deeds","2012 film",R.drawable.good_deeds),
                new MyMovieData("Hulk","2003 film",R.drawable.hulk),
                new MyMovieData("Avatar","2009 film",R.drawable.avatar),
        };

        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData, Fragment2.this);
        recyclerView.setAdapter(myMovieAdapter);








        return v;

    }
}