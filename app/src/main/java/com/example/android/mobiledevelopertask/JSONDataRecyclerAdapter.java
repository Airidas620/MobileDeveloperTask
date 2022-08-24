package com.example.android.mobiledevelopertask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android.mobiledevelopertask.models.JSONData;

public class JSONDataRecyclerAdapter extends RecyclerView.Adapter<JSONDataRecyclerAdapter.JSONDataViewHolder> {

    private JSONData jsonData;
    private ImageView enlargedURLImage;

    public JSONDataRecyclerAdapter(ImageView enlargedURLImage) {
        this.enlargedURLImage = enlargedURLImage;
    }

    @NonNull
    @Override
    public JSONDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.json_data_item_layout, parent, false);
        return new JSONDataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull JSONDataViewHolder holder, int position) {

        Glide.with(holder.urlImage).load(jsonData.getUrls()[position]).into(holder.urlImage);

        holder.urlTitle.setText(Integer.toString(jsonData.getUrlDigits()[position]));

    }

    @Override
    public int getItemCount() {
        if(jsonData != null){
            return jsonData.getUrls().length;
        }
        return 0;
    }

    class JSONDataViewHolder extends RecyclerView.ViewHolder {
        private TextView urlTitle;
        private ImageView urlImage;

        public JSONDataViewHolder(View itemView) {
            super(itemView);
            urlTitle = itemView.findViewById(R.id.url_digits);
            urlImage = itemView.findViewById(R.id.url_image);

            //Sets enlarged image content and makes it visible
            urlImage.setOnClickListener(view -> {
                enlargedURLImage.setImageDrawable(urlImage.getDrawable());
                enlargedURLImage.setVisibility(View.VISIBLE);
            });
        }
    }


    public void setJsonData(JSONData jsonData) {
        this.jsonData = jsonData;
        notifyDataSetChanged();
    }

    public void setEnlargedURLImage(ImageView enlargedURLImage) {
        this.enlargedURLImage = enlargedURLImage;
    }

}
