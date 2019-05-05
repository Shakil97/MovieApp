package com.example.movieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter {


    List<Result> movieList;
    Context context;

    public MovieAdapter(List<Result> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.list_item_top_rated_movie,viewGroup,false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        ((ViewHolder) viewHolder).titleText.setText(movieList.get(i).getTitle());
        ((ViewHolder) viewHolder).summeryText.setText(movieList.get(i).getOverview());
        ((ViewHolder) viewHolder).ratingText.setText("Rating"+movieList.get(i).getVoteAverage());

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+movieList.get(i).getPosterPath())
                .into(((ViewHolder) viewHolder).posterView);



    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView posterView;
        TextView titleText;
        TextView ratingText;
        TextView summeryText;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

          posterView=itemView.findViewById(R.id.poster);
          titleText=itemView.findViewById(R.id.title);
          ratingText=itemView.findViewById(R.id.rating);
          summeryText=itemView.findViewById(R.id.summery);

        }
    }

}
