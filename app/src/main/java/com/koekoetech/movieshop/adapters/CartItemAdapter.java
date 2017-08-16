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
import com.koekoetech.movieshop.model.CartItem;

import java.util.List;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.MyViewHolder> {

    private List<CartItem> cartItemList;
    private Context context;

    public CartItemAdapter(Context context,List<CartItem> cartItemList) {
        this.context = context;
        this.cartItemList = cartItemList;
    }

    @Override
    public CartItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_cart_item, parent, false);

        return new CartItemAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartItemAdapter.MyViewHolder holder, int position) {
        CartItem cartItem = cartItemList.get(position);
        Glide.with(context)
                .load(cartItem.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);
        holder.itemMovieName.setText(cartItem.getMovieName());
        holder.itemMovieSubtitle.setText(cartItem.getMovieSubtitle());
        holder.itemMoviePrice.setText(cartItem.getMoviePrice());
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView itemMovieName,itemMovieSubtitle,itemMoviePrice;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.cartImage);
            itemMovieName = (TextView) view.findViewById(R.id.cartMovieName);
            itemMovieSubtitle = (TextView) view.findViewById(R.id.cartSubtitle);
            itemMoviePrice = (TextView) view.findViewById(R.id.cartMoviePrice);
        }
    }

}
