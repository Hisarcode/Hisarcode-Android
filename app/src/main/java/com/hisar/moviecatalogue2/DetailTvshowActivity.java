package com.hisar.moviecatalogue2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailTvshowActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "extra_tvshow" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshow);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(R.string.detail_head_tvshow);
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvDescription = findViewById(R.id.tv_description);
        TextView tvUserscore = findViewById(R.id.tv_userscore);
        TextView tvDate = findViewById(R.id.tv_date);
        TextView tvRuntime = findViewById(R.id.tv_runtime);
        TextView tvEpisode = findViewById(R.id.tv_episode);
        ImageView imgObject = findViewById(R.id.img_poster);

        Tvshow tvshow = getIntent().getParcelableExtra(EXTRA_TVSHOW);
        assert tvshow != null;
        tvName.setText(tvshow.getName());
        tvDescription.setText(tvshow.getDescription());
        tvUserscore.setText(tvshow.getUserscore());
        tvDate.setText(tvshow.getDate());
        tvRuntime.setText(tvshow.getRuntime());
        tvEpisode.setText(tvshow.getEpisode());
        int imgPhoto = tvshow.getPhoto();
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
