package com.example.listdisplay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;
import androidx.core.content.ContextCompat;
import android.content.Intent;

//The Adapter connects the data (List<Recipe> to the RecyclerView UI

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.VH> {
    private final List<Recipe> items;

    public RecipeAdapter(List<Recipe> items){
        this.items= items;
    }

    //ViewHolder will hold references to views inside a single row for fast reuse
    public static class VH extends RecyclerView.ViewHolder{
        final TextView title;
        final ImageView Thumbnail;
        final TextView tvSummary;


        public VH(@NonNull View itemView){
            super(itemView);
            // Cache the TextView so we don't call findViewById repeatedly
            title = itemView.findViewById(R.id.tvTitle);
            Thumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvSummary = itemView.findViewById(R.id.tvSummary);
        }
    }

    //Called when RecyclerView needs a new row
    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Recipe r = items.get(position);
        holder.title.setText(r.title);
        holder.tvSummary.setText(r.description);

        // thumbnail (fallback if any imageResId is 0)
        int img = (r.imageResId != 0) ? r.imageResId : android.R.drawable.ic_menu_report_image;
        holder.Thumbnail.setImageResource(img);

        // BRIGHT COLORS BY COUNTRY
        Context ctx = holder.itemView.getContext();

        int titleColor = ContextCompat.getColor(ctx, R.color.titleText);
        int bgColor    = 0xFFFFFFFF; // default white

        String desc = r.description == null ? "" : r.description;

        if (desc.startsWith("Ghana")) {
            titleColor = ContextCompat.getColor(ctx, R.color.accentGhana);
            bgColor    = ContextCompat.getColor(ctx, R.color.bgGhana);
        } else if (desc.startsWith("India")) {
            titleColor = ContextCompat.getColor(ctx, R.color.accentIndia);
            bgColor    = ContextCompat.getColor(ctx, R.color.bgIndia);
        } else if (desc.startsWith("Bangladesh")) {
            titleColor = ContextCompat.getColor(ctx, R.color.accentBangladesh);
            bgColor    = ContextCompat.getColor(ctx, R.color.bgBangladesh);
        }

        holder.title.setTextColor(titleColor);
        holder.itemView.setBackgroundColor(bgColor);

        // -----------------------------
        // Task 4: Click listener for DetailActivity
        // -----------------------------
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(ctx, DetailActivity.class);
            intent.putExtra("title", r.title);
            intent.putExtra("imageResId", r.imageResId);
            intent.putExtra("description", r.description);
            ctx.startActivity(intent);
        });
    }


    // Tells RecyclerView how many rows to render (should be 15 here)
    @Override
    public int getItemCount() {
        return items.size();
    }
}
