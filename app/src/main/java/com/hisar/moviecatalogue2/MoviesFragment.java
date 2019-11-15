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
public class MoviesFragment extends Fragment {

    private ArrayList<Movie> list = new ArrayList<>();
    private String[] movieName;
    private String[] movieDescription;
    private String[] movieUserScore;
    private String[] movieRuntime;
    private String[] movieDate;
    private TypedArray moviePhoto;

    public MoviesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        RecyclerView rvMovie = view.findViewById(R.id.rv_movies);
        rvMovie.setHasFixedSize(true);

        movieName = view.getResources().getStringArray(R.array.movie_name);
        movieDescription = view.getResources().getStringArray(R.array.movie_description);
        movieUserScore = view.getResources().getStringArray(R.array.movie_user_score);
        movieDate = view.getResources().getStringArray(R.array.movie_date);
        movieRuntime = view.getResources().getStringArray(R.array.movie_runtime);
        moviePhoto =  view.getResources().obtainTypedArray(R.array.movie_photo);

        addItem();

        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));

        CardViewMovieAdapter cardViewMovieAdapter = new CardViewMovieAdapter(list);
        rvMovie.setAdapter(cardViewMovieAdapter);

        return view;
    }

    private void addItem(){
        list = new ArrayList<>();

        for(int i = 0; i < movieName.length ; i++){
            Movie movie = new Movie();
            movie.setPhoto(moviePhoto.getResourceId(i, -1));
            movie.setName(movieName[i]);
            movie.setDescription(movieDescription[i]);
            movie.setUserscore(movieUserScore[i]);
            movie.setDate(movieDate[i]);
            movie.setRuntime(movieRuntime[i]);
            list.add(movie);
        }
    }
}
