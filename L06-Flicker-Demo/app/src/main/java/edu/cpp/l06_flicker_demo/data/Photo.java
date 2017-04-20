package edu.cpp.l06_flicker_demo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yusun on 4/19/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url_s")
    private String url_s;
    @JsonProperty("owner")
    private String owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl_s() {
        return url_s;
    }

    public void setUrl_s(String url_s) {
        this.url_s = url_s;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
