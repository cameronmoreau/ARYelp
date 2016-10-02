package org.cameronmoreau.aryelp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import org.cameronmoreau.aryelp.R;
import org.cameronmoreau.aryelp.models.Place;

import java.util.ArrayList;

/**
 * Created by Cameron on 10/2/16.
 */

public class PlacesListAdapter extends RecyclerView.Adapter<PlacesListAdapter.ViewHolder> {

    ArrayList<Place> places;

    public PlacesListAdapter() {
        this.places = new ArrayList<>();
    }

    public void addPlace(Place place) {
        places.add(place);
        this.notifyItemInserted(places.size() - 1);
    }

    @Override
    public PlacesListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.places_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlacesListAdapter.ViewHolder holder, int position) {
        holder.setPlace(places.get(position));
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        RatingBar ratingBar;

        ViewHolder(View view) {
            super(view);

            tvName = (TextView) view.findViewById(R.id.tv_name);
            ratingBar = (RatingBar) view.findViewById(R.id.rating);
        }

        void setPlace(Place place) {
            tvName.setText(place.getName());
            ratingBar.setRating((float) place.getRating());
        }
    }
}
