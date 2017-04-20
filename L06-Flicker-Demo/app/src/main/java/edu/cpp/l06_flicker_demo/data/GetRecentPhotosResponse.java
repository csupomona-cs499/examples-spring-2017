package edu.cpp.l06_flicker_demo.data;

/**
 * Created by yusun on 4/19/17.
 */

public class GetRecentPhotosResponse {

    private String stat;
    private Photos photos;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}
