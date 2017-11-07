package com.bferrari.tourapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bferrari on 07/11/17.
 */

public class FoodFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PlaceAdapter mAdapter;

    private List<Place> mPlaces = new ArrayList<>();

    //Required public empty constructor
    public FoodFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillListWithData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food, container, false);

        mRecyclerView = rootView.findViewById(R.id.food_recycler_view);
        mAdapter = new PlaceAdapter();

        mAdapter.setData(mPlaces);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void fillListWithData() {
        mPlaces.add(new Place(getString(R.string.by_koji), getString(R.string.by_koji_addr), R.drawable.bykoji));
        mPlaces.add(new Place(getString(R.string.brace_bar), getString(R.string.brace_bar_addr), R.drawable.bracebaregriglia));
        mPlaces.add(new Place(getString(R.string.brasserie_victoria), getString(R.string.brasserie_victoria_addr), R.drawable.brasserie_victoria_sfiha));
        mPlaces.add(new Place(getString(R.string.comedoria), getString(R.string.comedoria_addr), R.drawable.comedoria_gonzales_ceviche));
        mPlaces.add(new Place(getString(R.string.tuju), getString(R.string.tuju_addr), R.drawable.tuju));
    }
}
