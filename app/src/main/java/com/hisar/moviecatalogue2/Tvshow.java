package com.hisar.moviecatalogue2;

import android.os.Parcel;
import android.os.Parcelable;

public class Tvshow implements Parcelable {
    private String name;
    private String description;
    private int photo;
    private String userscore;
    private String runtime;
    private String date;
    private String episode;

    Tvshow(){

    }

    private Tvshow(Parcel in) {
        name = in.readString();
        description = in.readString();
        photo = in.readInt();
        userscore = in.readString();
        runtime = in.readString();
        date = in.readString();
        episode = in.readString();
    }

    public static final Creator<Tvshow> CREATOR = new Creator<Tvshow>() {
        @Override
        public Tvshow createFromParcel(Parcel in) {
            return new Tvshow(in);
        }

        @Override
        public Tvshow[] newArray(int size) {
            return new Tvshow[size];
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

    String getEpisode() {
        return episode;
    }

    void setEpisode(String episode) {
        this.episode = episode;
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
        parcel.writeString(episode);
    }
}
