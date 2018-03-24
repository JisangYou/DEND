package com.example.a365mc_inno1.facecheckgame.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 365mc_inno1 on 2018-03-21.
 */

public class Staff implements Parcelable {

    int url;
    String name;
    int index;
    String sex;
    String dep;

    public Staff(String name, int url, int index, String sex, String dep) {
        this.url = url;
        this.name = name;
        this.index = index;
        this.sex = sex;
        this.dep = dep;
    }

    protected Staff(Parcel in) {
        url = in.readInt();
        name = in.readString();
        index = in.readInt();
        sex = in.readString();
        dep = in.readString();
    }

    public static final Creator<Staff> CREATOR = new Creator<Staff>() {
        @Override
        public Staff createFromParcel(Parcel in) {
            return new Staff(in);
        }

        @Override
        public Staff[] newArray(int size) {
            return new Staff[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(url);
        dest.writeString(name);
        dest.writeInt(index);
        dest.writeString(sex);
        dest.writeString(dep);
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
}
