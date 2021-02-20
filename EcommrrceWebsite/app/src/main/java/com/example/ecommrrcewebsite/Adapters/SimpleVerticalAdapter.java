package com.example.ecommrrcewebsite.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ecommrrcewebsite.Models.PlateModel;
import com.example.ecommrrcewebsite.Models.SimpleVerticalModel;
import com.example.ecommrrcewebsite.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleVerticalAdapter extends RecyclerView.Adapter<SimpleVerticalAdapter.PlateViewHolder> {

    private List<SimpleVerticalModel> simpleVerticalModelList;
    private Context context;

    public SimpleVerticalAdapter(List<SimpleVerticalModel> simpleVerticalModelList, Context context) {
        this.simpleVerticalModelList = simpleVerticalModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_vertical_slider,viewGroup,false);
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {

        SimpleVerticalModel simpleVerticalModel = simpleVerticalModelList.get(position);

        Glide.with(context).load(simpleVerticalModel.getPro_img()).into(holder.proImg);
        holder.pro_Title.setText(simpleVerticalModel.getSimple_title());
        holder.pro_Desc.setText(simpleVerticalModel.getSimple_discription());
        holder.pro_Coupon.setText(simpleVerticalModel.getSimple_coupon());
        holder.pro_Quantity.setText(simpleVerticalModel.getSimple_quantity());
        holder.pro_money.setText(simpleVerticalModel.getSimple_money());

    }

    @Override
    public int getItemCount() {
        return simpleVerticalModelList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {
        private ImageView proImg;
        private TextView pro_Title, pro_Desc, pro_Coupon, pro_Quantity, pro_money ;
        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);
            proImg = (ImageView) itemView.findViewById(R.id.imageView6);
            pro_Title = (TextView) itemView.findViewById(R.id.textView4);
            pro_Desc = (TextView) itemView.findViewById(R.id.textView5);
            pro_money = (TextView) itemView.findViewById(R.id.textView6);
            pro_Coupon = (TextView) itemView.findViewById(R.id.textView7);
            pro_Quantity = (TextView) itemView.findViewById(R.id.textView8);


        }
    }
}

