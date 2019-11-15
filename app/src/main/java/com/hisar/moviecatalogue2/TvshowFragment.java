package com.hisar.moviecatalogue2;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvshowFragment extends Fragment {

    private ArrayList<Tvshow> list = new ArrayList<>();
    private String[] tvshowName;
    private String[] tvshowDescription;
    private String[] tvshowUserScore;
    private String[] tvshowRuntime;
    private String[] tvshowDate;
    private TypedArray tvshowPhoto;
    private String[] tvshowEpisode;

    public TvshowFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tvshow, container, false);
        RecyclerView rvTvshow = view.findViewById(R.id.rv_tvshow);
        rvTvshow.setHasFixedSize(true);

        tvshowName = view.getResources().getStringArray(R.array.tvshow_names);
        tvshowDescription = view.getResources().getStringArray(R.array.tvshow_description);
        tvshowUserScore = view.getResources().getStringArray(R.array.tvshow_user_score);
        tvshowDate = view.getResources().getStringArray(R.array.tvshow_date);
        tvshowRuntime = view.getResources().getStringArray(R.array.tvshow_runtime);
        tvshowPhoto =  view.getResources().obtainTypedArray(R.array.tvshow_photo);
        tvshowEpisode = view.getResources().getStringArray(R.array.tvshow_episode);

        addItem();

        rvTvshow.setLayoutManager(new LinearLayoutManager(getActivity()));

        CardViewTvshowAdapter cardViewTvshowAdapter = new CardViewTvshowAdapter(list);
        rvTvshow.setAdapter(cardViewTvshowAdapter);

        return view;
    }

    private void addItem(){
        list = new ArrayList<>();

        for(int i = 0; i < tvshowName.length ; i++){
            Tvshow tvshow = new Tvshow();
            tvshow.setPhoto(tvshowPhoto.getResourceId(i, -1));
            tvshow.setName(tvshowName[i]);
            tvshow.setDescription(tvshowDescription[i]);
            tvshow.setUserscore(tvshowUserScore[i]);
            tvshow.setDate(tvshowDate[i]);
            tvshow.setRuntime(tvshowRuntime[i]);
            tvshow.setEpisode(tvshowEpisode[i]);
            list.add(tvshow);
        }
    }
}
