package com.koekoetech.movieshop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.koekoetech.movieshop.R;
import com.koekoetech.movieshop.model.IMDBMovie;

import java.util.List;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class IMDBMovieAdapter extends RecyclerView.Adapter<IMDBMovieAdapter.MyViewHolder> {

    private List<IMDBMovie> imdbMovieList;
    private Context context;

    public IMDBMovieAdapter(Context context, List<IMDBMovie> imdbMovieList) {
        this.context = context;
        this.imdbMovieList = imdbMovieList;
    }

    @Override
    public IMDBMovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_imdb_item, parent, false);

        return new IMDBMovieAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IMDBMovieAdapter.MyViewHolder holder, int position) {
        IMDBMovie imdbMovie = imdbMovieList.get(position);
        Glide.with(context)
                .load(imdbMovie.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);
        holder.itemNumber.setText(String.valueOf(imdbMovie.getCountNumber()));
        holder.itemTitle.setText(imdbMovie.getMovieName());
        holder.itemSubtitle.setText(imdbMovie.getMovieSubtitle());
        holder.itemRating.setText(imdbMovie.getMovieRating());
    }

    @Override
    public int getItemCount() {
        return imdbMovieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView itemNumber, itemTitle, itemSubtitle, itemRating;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.itemImage);
            itemNumber = (TextView) view.findViewById(R.id.itemNumber);
            itemTitle = (TextView) view.findViewById(R.id.itemTitle);
            itemSubtitle = (TextView) view.findViewById(R.id.itemSubtitle);
            itemRating = (TextView) view.findViewById(R.id.itemRating);
        }
    }

}
