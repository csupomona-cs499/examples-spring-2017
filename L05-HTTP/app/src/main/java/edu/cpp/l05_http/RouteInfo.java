package edu.cpp.l05_http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yusun on 4/17/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteInfo {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("RouteID")
    private String routeId;
    @JsonProperty("Latitude")
    private double latitude;
    @JsonProperty("Longitude")
    private double longitude;
    @JsonProperty("Speed")
    private int speed;
    @JsonProperty("Heading")
    private String heading;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String toString() {
        return "Id: " + id + ", " + "Lat: " + latitude + ", Lon: " + longitude;
    }
}
