package com.ganipohan.unikqu.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.ganipohan.unikqu.R;
import com.ganipohan.unikqu.TravelLocationModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder> {
    private List<TravelLocationModel> travelLocationModels;

    public TravelLocationAdapter(List<TravelLocationModel> travelLocationModels) {
        this.travelLocationModels = travelLocationModels;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_location,parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewHolder holder, int position) {
        holder.setLocationData(travelLocationModels.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocationModels.size();
    }

    static class  TravelLocationViewHolder extends RecyclerView.ViewHolder{
        private KenBurnsView kenBurnsView;
        private TextView textTitle, textLocation, textRating;

        TravelLocationViewHolder(@NonNull View itemView){
            super(itemView);
            kenBurnsView = itemView.findViewById(R.id.kenBurns);
            textTitle = itemView.findViewById(R.id.text_title);
            textLocation = itemView.findViewById(R.id.text_location);
            textRating = itemView.findViewById(R.id.text_rating);
        }
        void setLocationData(TravelLocationModel travelLocationModel){
            Picasso.get()
                    .load(travelLocationModel.imageUri)
                    .into(kenBurnsView);

            textTitle.setText(travelLocationModel.title);
            textLocation.setText(travelLocationModel.location);
            textRating.setText(String.valueOf(travelLocationModel.rating));
        }
    }
}
