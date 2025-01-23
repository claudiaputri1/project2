package com.example.project2.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.R;
import com.example.project2.model.nearby.ModelResults;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    ArrayList<ModelResults> modelResultsArrayList = new ArrayList<>();
    Context context;

    public MainAdapter(Context context) {
        this.context = context;
    }

    public void setLocationAdapter(ArrayList<ModelResults> items) {
        modelResultsArrayList.clear();
        modelResultsArrayList.addAll(items);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rekomendasi, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        ModelResults modelResults = modelResultsArrayList.get(position);

        // set rating
        float newValue = (float) modelResults.getRating();
        holder.ratingBar.setNumStars(5);
        holder.ratingBar.setStepSize((float) 0.5);
        holder.ratingBar.setRating(newValue);

        holder.tvNamaJalan.setText(modelResults.getVicinity());
        holder.tvNamaLokasi.setText(modelResults.getName());
        holder.tvRating.setText("(" + modelResults.getRating() + ")");
    }

    @Override
    public int getItemCount() {
        return modelResultsArrayList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearRute;
        TextView tvNamaJalan, tvNamaLokasi, tvRating;
        RatingBar ratingBar;

        public MainViewHolder(View itemView) {
            super(itemView);
            linearRute = itemView.findViewById(R.id.linearRute);
            tvNamaJalan = itemView.findViewById(R.id.tvNamaJalan);
            tvNamaLokasi = itemView.findViewById(R.id.tvNamaLokasi);
            tvRating = itemView.findViewById(R.id.tvRating);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}