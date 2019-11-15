package com.hisar.moviecatalogue2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(R.string.detail_head_movie);
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvUserscore = findViewById(R.id.tv_userscore);
        TextView tvDate = findViewById(R.id.tv_date);
        TextView tvRuntime = findViewById(R.id.tv_runtime);
        ImageView imgObject = findViewById(R.id.img_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        assert movie != null;
        tvName.setText(movie.getName());
        tvDescription.setText(movie.getDescription());
        tvUserscore.setText(movie.getUserscore());
        tvDate.setText(movie.getDate());
        tvRuntime.setText(movie.getRuntime());
        int imgPhoto = movie.getPhoto();
        imgObject.setImageResource(imgPhoto);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
