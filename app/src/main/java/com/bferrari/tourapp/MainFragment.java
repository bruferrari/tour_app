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

public class MainFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private PlaceAdapter mAdapter;

    private List<Place> mPlaces = new ArrayList<>();

    //Required public empty constructor
    public MainFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillListWithData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = rootView.findViewById(R.id.main_recycler_view);
        mAdapter = new PlaceAdapter();

        mAdapter.setData(mPlaces);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private void fillListWithData() {
        mPlaces.add(new Place("São Paulo Cathedral", "Cathedral Square, s / n - Centro - São Paulo (Metro)", R.drawable.saopaulocathedral_1t));
        mPlaces.add(new Place("Caixa Econômica Federal Museum", "Caixa Cultural Pc Se, 111 - São Paulo", R.drawable.caixaeconomicafederalmuseum_1t));
        mPlaces.add(new Place("Telephone Museum", "Rua Benjamin Constant 174 - 5 andar, Centro", R.drawable.telefonemuseum_1t));
        mPlaces.add(new Place("Ibirapuera Park", "Avenida Pedro Alvares Cabral, São Paulo", R.drawable.ibirapuera_park));
        mPlaces.add(new Place("Independency Park", "Parque da Independência, Ipiranga, São Paulo", R.drawable.brazil_sao_paulo_parque_independancia));
    }
}
