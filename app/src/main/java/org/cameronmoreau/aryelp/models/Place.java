package org.cameronmoreau.aryelp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Cameron on 10/1/16.
 */

public class Place {

    @SerializedName("place_id")
    String id;

    String name;

    @SerializedName("formatted_address")
    String address;

    List<PlacePhoto> photos;

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

    public List<PlacePhoto> getPhotos() {
        return photos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhotos(List<PlacePhoto> photos) {
        this.photos = photos;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPriceLevel(int priceLevel) {
        this.priceLevel = priceLevel;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", photos=" + photos +
                ", rating=" + rating +
                ", priceLevel=" + priceLevel +
                ", website='" + website + '\'' +
                '}';
    }
}
