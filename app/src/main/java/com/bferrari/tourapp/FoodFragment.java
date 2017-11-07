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
        mPlaces.add(new Place("By Koji", "Pça. Roberto Gomes Pedrosa, São Paulo, SP 05653-070, Brazil", R.drawable.bykoji));
        mPlaces.add(new Place("Brace Bar e Griglia", "Eataly São Paulo, SP 04543-011, Brazil", R.drawable.bracebaregriglia));
        mPlaces.add(new Place("Brasserie Victória", "Av. Pres. Juscelino Kubitschek 545, São Paulo, SP 04543-010, Brazil", R.drawable.brasserie_victoria_sfiha));
        mPlaces.add(new Place("Comedoria Gonzales", "Mercado Municipal de Pinheiros São Paulo, SP 05421-040, Brazil", R.drawable.comedoria_gonzales_ceviche));
        mPlaces.add(new Place("TUJU", "R. Fradique Coutinho 1248, São Paulo, SP 05416-001, Brazil", R.drawable.tuju));
    }
}
