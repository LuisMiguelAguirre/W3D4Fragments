package com.example.admin.w3d4fragments;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Luis Aguirre on 9/6/2017.
 */

public class Famous implements Parcelable {

    private String name;
    private String description;
    private int image_id;

    public Famous(String name, String description, int image_id) {
        this.name = name;
        this.description = description;
        this.image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeInt(this.image_id);
    }

    protected Famous(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.image_id = in.readInt();
    }

    public static final Parcelable.Creator<Famous> CREATOR = new Parcelable.Creator<Famous>() {
        @Override
        public Famous createFromParcel(Parcel source) {
            return new Famous(source);
        }

        @Override
        public Famous[] newArray(int size) {
            return new Famous[size];
        }
    };
}
