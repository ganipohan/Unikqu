package com.ganipohan.unikqu.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ganipohan.unikqu.R;
import com.ganipohan.unikqu.TravelLocationModel;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    ViewPager2 viewPager2;
    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        viewPager2 = view.findViewById(R.id.viewPager);
        data();

        return view;
    }

    public void data() {
        List<TravelLocationModel> travelLocationModels = new ArrayList<>();

        TravelLocationModel travelLocationEiffelTower = new TravelLocationModel();
        travelLocationEiffelTower.imageUri = "https://www.pexels.com/photo/photo-of-eiffel-tower-739407/";
        travelLocationEiffelTower.title = "Francis";
        travelLocationEiffelTower.location = "Eiffel Tower";
        travelLocationEiffelTower.rating = 4.0f;
        travelLocationModels.add(travelLocationEiffelTower);

        TravelLocationModel travelLocationOcean = new TravelLocationModel();
        travelLocationOcean.imageUri = "https://www.pexels.com/photo/aerial-shot-of-buildings-near-ocean-1682794/";
        travelLocationOcean.title = "Ocean";
        travelLocationOcean.location = "Arie Ocean";
        travelLocationOcean.rating = 3.0f;
        travelLocationModels.add(travelLocationOcean);

        TravelLocationModel travelLocationPagoda = new TravelLocationModel();
        travelLocationPagoda.imageUri = "https://www.pexels.com/photo/canoe-on-body-of-water-with-pagoda-background-2166559/";
        travelLocationPagoda.title = "Pagoda";
        travelLocationPagoda.location = "Tugu pagoda bali";
        travelLocationPagoda.rating = 5.0f;
        travelLocationModels.add(travelLocationPagoda);

        viewPager2.setAdapter(new TravelLocationAdapter(travelLocationModels));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.9f + r * 0.05f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

    }
}