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

public class TourFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PlaceAdapter mAdapter;

    private List<Place> mPlaces = new ArrayList<>();

    //Required public empty constructor
    public TourFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillListWithData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tour, container, false);

        mRecyclerView = rootView.findViewById(R.id.tour_recycler_view);
        mAdapter = new PlaceAdapter();

        mAdapter.setData(mPlaces);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void fillListWithData() {
        mPlaces.add(new Place(getString(R.string.masp), getString(R.string.masp_addr), R.drawable.p_sp_masp_r));
        mPlaces.add(new Place(getString(R.string.aquarium), getString(R.string.aquarium_addr), R.drawable.aquario));
        mPlaces.add(new Place(getString(R.string.latim_america_memorial), getString(R.string.latim_america_memorial_addr), R.drawable.fundacao_memorial_da_america_latina));
        mPlaces.add(new Place(getString(R.string.football), getString(R.string.football_addr), R.drawable.museufutebol));
        mPlaces.add(new Place(getString(R.string.theatro_municipal), getString(R.string.theatro_municipal_addr), R.drawable.saguao_do_theatro_municipal_de_sao_paulo_sp_no_vale_do_anhangabau));
    }
}
