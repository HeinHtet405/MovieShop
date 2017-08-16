package com.koekoetech.movieshop.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class IMDBMovie implements Parcelable{

    private int countNumber;
    private String movieName;
    private String movieSubtitle;
    private String movieRating;
    private String imageUrl;

    public IMDBMovie() {
    }

    public IMDBMovie(int countNumber, String movieName, String movieSubtitle, String movieRating, String imageUrl) {
        this.countNumber = countNumber;
        this.movieName = movieName;
        this.movieSubtitle = movieSubtitle;
        this.movieRating = movieRating;
        this.imageUrl = imageUrl;
    }

    protected IMDBMovie(Parcel in) {
        countNumber = in.readInt();
        movieName = in.readString();
        movieSubtitle = in.readString();
        movieRating = in.readString();
        imageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(countNumber);
        dest.writeString(movieName);
        dest.writeString(movieSubtitle);
        dest.writeString(movieRating);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IMDBMovie> CREATOR = new Creator<IMDBMovie>() {
        @Override
        public IMDBMovie createFromParcel(Parcel in) {
            return new IMDBMovie(in);
        }

        @Override
        public IMDBMovie[] newArray(int size) {
            return new IMDBMovie[size];
        }
    };

    public int getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(int countNumber) {
        this.countNumber = countNumber;
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

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "IMDBMovie{" +
                "countNumber=" + countNumber +
                ", movieName='" + movieName + '\'' +
                ", movieSubtitle='" + movieSubtitle + '\'' +
                ", movieRating='" + movieRating + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
