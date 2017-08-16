package com.koekoetech.movieshop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.koekoetech.movieshop.R;
import com.koekoetech.movieshop.model.Movie;

import java.util.List;

/**
 * Created by Hein Htet on 8/16/2017.
 **/

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private List<Movie> moviesList;
    private Context context;
    private MovieListItemClickable listener;

    public MovieListAdapter(Context context,List<Movie> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.item_movie_poster);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.movieListItemClickListener();
                }
            });
        }
    }

    public void setListener(MovieListItemClickable listener) {
        this.listener = listener;
    }

    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_movie_item, parent, false);

        return new MovieListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        Glide.with(context)
                .load(movie.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public interface MovieListItemClickable {
        void movieListItemClickListener();
    }

}
