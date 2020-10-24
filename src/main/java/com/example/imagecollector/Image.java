package com.example.imagecollector;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Image {

    private Integer image_id;

    private String url;

    private Integer no_of_times_accessed;


    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNo_of_times_accessed() {
        return no_of_times_accessed;
    }

    public void setNo_of_times_accessed(Integer no_of_times_accessed) {
        this.no_of_times_accessed = no_of_times_accessed;
    }

    @Override
    public String toString() {
        return "Image{" +
                "image_id=" + image_id +
                ", url='" + url + '\'' +
                ", no_of_times_accessed=" + no_of_times_accessed +
                '}';
    }
}
