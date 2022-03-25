package com.example.dissapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

    Context context;
    String[] placesNameList;
    String[] placesDateList;
    String[] placesDescriptionList;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rowName;
        TextView rowDate;
        TextView rowDescription;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.textView1);
            rowDate = itemView.findViewById(R.id.textView3);
            rowDescription = itemView.findViewById(R.id.textView2);
            rowImage = itemView.findViewById(R.id.imageView);
        }
    }


    public PlacesAdapter(Context context, String[] placesNameList, String[] placesDateList, String[] placesDescriptionList, int[] images){
        this.context = context;
        this.placesNameList = placesNameList;
        this.placesDateList = placesDateList;
        this.placesDescriptionList = placesDescriptionList;
        this.images = images;
    }

    @NonNull
    @Override
    public PlacesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull PlacesAdapter.ViewHolder holder, int position) {
        holder.rowName.setText(placesNameList[position]);
        holder.rowDate.setText(placesDateList[position]);
        holder.rowDescription.setText(placesDescriptionList[position]);
        holder.rowImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return placesNameList.length;
    }
}
