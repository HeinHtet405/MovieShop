package com.koekoetech.movieshop.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class CartItem implements Parcelable {

    private String imageUrl;
    private String movieName;
    private String movieSubtitle;
    private String moviePrice;

    public CartItem() {
    }

    public CartItem(String imageUrl, String movieName, String movieSubtitle, String moviePrice) {
        this.imageUrl = imageUrl;
        this.movieName = movieName;
        this.movieSubtitle = movieSubtitle;
        this.moviePrice = moviePrice;
    }

    protected CartItem(Parcel in) {
        imageUrl = in.readString();
        movieName = in.readString();
        movieSubtitle = in.readString();
        moviePrice = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(movieName);
        dest.writeString(movieSubtitle);
        dest.writeString(moviePrice);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieSubtitle() {
        return movieSubtitle;
    }

    public void setMovieSubtitle(String movieSubtitle) {
        this.movieSubtitle = movieSubtitle;
    }

    public String getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(String moviePrice) {
        this.moviePrice = moviePrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "imageUrl='" + imageUrl + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieSubtitle='" + movieSubtitle + '\'' +
                ", moviePrice='" + moviePrice + '\'' +
                '}';
    }
}
