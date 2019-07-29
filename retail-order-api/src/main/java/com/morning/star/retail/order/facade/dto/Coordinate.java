package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

public class Coordinate implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final double lat;
    private final double lng;

    public Coordinate() {
        this(0.0, 0.0);
    }

    public Coordinate(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "Coordinate [lat=" + lat + ", lng=" + lng + "]";
    }

}
