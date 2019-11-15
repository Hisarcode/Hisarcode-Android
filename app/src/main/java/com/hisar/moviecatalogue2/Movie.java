package com.hisar.moviecatalogue2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String name;
    private String description;
    private int photo;
    private String userscore;
    private String runtime;
    private String date;

    Movie(){

    }

    private Movie(Parcel in) {
        name = in.readString();
        description = in.readString();
        photo = in.readInt();
        userscore = in.readString();
        runtime = in.readString();
        date = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    int getPhoto() {
        return photo;
    }

    void setPhoto(int photo) {
        this.photo = photo;
    }

    String getUserscore() {
        return userscore;
    }

    void setUserscore(String userscore) {
        this.userscore = userscore;
    }

    String getRuntime() {
        return runtime;
    }

    void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    String getDate() {
        return date;
    }

    void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(photo);
        parcel.writeString(userscore);
        parcel.writeString(runtime);
        parcel.writeString(date);
    }
}
