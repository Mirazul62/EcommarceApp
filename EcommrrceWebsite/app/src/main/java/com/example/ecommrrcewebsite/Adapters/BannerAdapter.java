package com.example.ecommrrcewebsite.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ecommrrcewebsite.Models.BannerModel;
import com.example.ecommrrcewebsite.Models.CategoryModel;
import com.example.ecommrrcewebsite.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.PlateViewHolder> {

    private List<BannerModel> bannerModelList;
    private Context context;

    public BannerAdapter(List<BannerModel> bannerModelList, Context context) {
        this.bannerModelList = bannerModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_banner,viewGroup,false);
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {

        BannerModel bannerModel = bannerModelList.get(position);
        Glide.with(context).load(bannerModel.getBanner_img()).placeholder(R.drawable.sentiment).into(holder.banner_img);
    }

    @Override
    public int getItemCount() {
        return bannerModelList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {
        private ImageView banner_img;
        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);
            banner_img = (ImageView) itemView.findViewById(R.id.banner_img);

        }
    }
}


