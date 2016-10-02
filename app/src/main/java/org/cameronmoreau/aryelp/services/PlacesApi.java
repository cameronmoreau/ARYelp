package org.cameronmoreau.aryelp.services;

import org.cameronmoreau.aryelp.models.Place;
import org.cameronmoreau.aryelp.models.PlacesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Cameron on 10/1/16.
 */

public interface PlacesApi {

    //private static final String API_KEY = "AIzaSyBTuELqSKtgOgqjTU0EJ096aRm3cMdnSzQ";

    //https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&rankby=distance&types=food&key=YOUR_API_KEY

//    public interface Places {
//        @GET("nearbysearch/json?location=-33.8670522,151.1957362&rankby=distance&types=food&key=" + API_KEY)
//        Call<List<Place>> getNearbyPlaces();
//    }
//
//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("https://maps.googleapis.com/maps/api/place/")
//            .build();
//
//    PlacesApi service = retrofit.create(PlacesApi.class);

    @GET("nearbysearch/json?location=-33.8670522,151.1957362&rankby=distance&types=food&key=AIzaSyBTuELqSKtgOgqjTU0EJ096aRm3cMdnSzQ")
    Call<PlacesResult> getNearbyPlaces();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/place/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
