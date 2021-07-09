package com.islamicappsworld.baby.smart.growth;

/**
 * Created by Apple on 7/30/2016.
 */
public class dataproviderforlistview {

    private int imagesresourse;
    private String titlesresourse;

    public dataproviderforlistview(int images,String titles)
    {
        this.setTitlesresourse(titles);
        this.setImagesresourse(images);

    }

    public String getTitlesresourse() {
        return titlesresourse;
    }

    public void setTitlesresourse(String titlesresourse) {
        this.titlesresourse = titlesresourse;
    }

    public int getImagesresourse() {

        return imagesresourse;
    }

    public void setImagesresourse(int imagesresourse) {
        this.imagesresourse = imagesresourse;
    }
}
