package com.example.project_soccerinfo.news;

public class News {
    String imgUrl;
    String linkUrl;
    String title;

    public News(String imgUrl, String linkUrl, String title) {
        this.imgUrl = imgUrl;
        this.linkUrl = linkUrl;
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
