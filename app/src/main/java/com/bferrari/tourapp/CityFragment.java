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

public class CityFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PlaceAdapter mAdapter;

    private List<Place> mPlaces = new ArrayList<>();

    //Required public empty constructor
    public CityFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillListWithData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_city, container, false);

        mRecyclerView = rootView.findViewById(R.id.city_recycler_view);
        mAdapter = new PlaceAdapter();

        mAdapter.setData(mPlaces);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void fillListWithData() {
        mPlaces.add(new Place(getString(R.string.light_station), getString(R.string.light_station_address), R.drawable.turismo_centro_de_sao_paulo_luz));
        mPlaces.add(new Place(getString(R.string.light_park), getString(R.string.light_park_address), R.drawable.jardim_da_luz_centro_sp));
        mPlaces.add(new Place(getString(R.string.municipal_market), getString(R.string.municipal_market_addr), R.drawable.centro_de_sao_paulo_mercadao));
        mPlaces.add(new Place(getString(R.string.ibirapuera), getString(R.string.ibirapuera_addr), R.drawable.ibirapuera_park));
        mPlaces.add(new Place(getString(R.string.monastery), getString(R.string.monastery_addr), R.drawable.centro_de_sao_paulo_o_que_fazer));
    }
}
