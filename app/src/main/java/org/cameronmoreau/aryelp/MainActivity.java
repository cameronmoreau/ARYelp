package org.cameronmoreau.aryelp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.cameronmoreau.aryelp.adapters.PlacesListAdapter;
import org.cameronmoreau.aryelp.models.Place;
import org.cameronmoreau.aryelp.models.PlacesResult;
import org.cameronmoreau.aryelp.services.PlacesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView placesRecycler;
    PlacesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        placesRecycler = (RecyclerView) findViewById(R.id.rv_places);
        placesRecycler.setHasFixedSize(true);

        adapter = new PlacesListAdapter();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        placesRecycler.setLayoutManager(llm);
        placesRecycler.setAdapter(adapter);

        loadPlaces();
    }

    void loadPlaces() {
        PlacesApi api = PlacesApi.retrofit.create(PlacesApi.class);
        Call<PlacesResult> call = api.getNearbyPlaces();
        call.enqueue(new Callback<PlacesResult>() {
            @Override
            public void onResponse(Call<PlacesResult> call, Response<PlacesResult> response) {
                Log.d("TEST", "Worked!");

                List<Place> places = response.body().getResults();
                for(Place p : places) {
                    adapter.addPlace(p);
                }
            }

            @Override
            public void onFailure(Call<PlacesResult> call, Throwable t) {
                Log.e("TEST", "Failed!");
                Log.e("TEST", t.getMessage());
            }
        });
    }
}
