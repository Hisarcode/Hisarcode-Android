package com.hisar.moviecatalogue2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class CardViewTvshowAdapter extends RecyclerView.Adapter<CardViewTvshowAdapter.CardViewViewHolder> {

    private ArrayList<Tvshow> listTvshows;

    CardViewTvshowAdapter(ArrayList<Tvshow> list){
        this.listTvshows = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_tvshow, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, final int position) {

        Tvshow tvshow = listTvshows.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvshow.getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);
        holder.tvName.setText(tvshow.getName());
        holder.tvDescription.setText(tvshow.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tvshow tvshow = listTvshows.get(position);

                Intent detailIntent = new Intent(holder.itemView.getContext(), DetailTvshowActivity.class);
                detailIntent.putExtra(DetailTvshowActivity.EXTRA_TVSHOW , tvshow);
                holder.itemView.getContext().startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTvshows.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;


        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_tvshow_photo);
            tvName = itemView.findViewById(R.id.tv_tvshow_name);
            tvDescription = itemView.findViewById(R.id.tv_tvshow_description);
        }
    }
}