package com.developersiddhantkashyap.craftywallpaper;

public class WallpaperModel {

    private  String imgView;
    private String imgName;

    public WallpaperModel(String imgView, String imgName) {
        this.imgView = imgView;
        this.imgName = imgName;
    }

    public WallpaperModel() {

    }


    public String getImgView() {
        return imgView;
    }

    public  void setImgView(String imgView) {
        this.imgView = imgView;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}
