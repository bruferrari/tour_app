package com.bferrari.tourapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bferrari on 07/11/17.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private List<Place> mPlaces = new ArrayList<>();
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView locationName;
        private TextView locationAddress;
        private ImageView locationImage;

        public ViewHolder(View itemView) {
            super(itemView);
            locationName = itemView.findViewById(R.id.location_name);
            locationAddress = itemView.findViewById(R.id.location_address);
            locationImage = itemView.findViewById(R.id.location_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Place place = mPlaces.get(getAdapterPosition());
            String uri = "http://maps.google.com/maps?q=" + place.getAddress();
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place = mPlaces.get(position);

        holder.locationName.setText(place.getName());
        holder.locationAddress.setText(place.getAddress());

        Glide.with(mContext)
                .load(place.getImageResId())
                .apply(new RequestOptions().centerCrop())
                .into(holder.locationImage);

    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

    public void setData(List<Place> places) {
        mPlaces = places;
        notifyDataSetChanged();
    }
}
