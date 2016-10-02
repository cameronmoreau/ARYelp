package org.cameronmoreau.aryelp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Cameron on 10/1/16.
 */

public class Place {

    @SerializedName("place_id")
    String id;

    String name;

//    LatLng location;
    @SerializedName("formatted_address")
    String address;


//    String type;
//    String imageUrl;
//
    double rating;

    @SerializedName("price_level")
    int priceLevel;

//    String phone;
    String website;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getRating() {
        return rating;
    }

    public int getPriceLevel() {
        return priceLevel;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", priceLevel=" + priceLevel +
                ", website='" + website + '\'' +
                '}';
    }
}
