package com.luxcar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.luxcar.R;
import com.luxcar.models.entities.Brand;

import java.util.ArrayList;

public class AdapterBrand extends RecyclerView.Adapter<AdapterBrand.ViewHolder> {

    ArrayList<Brand> brands;

    public AdapterBrand(ArrayList<Brand> brands) {
        this.brands = brands;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.acctivity_home_custom_item_categories,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(brands.get(position).getName());
        String picUrl = "";
        switch (position){
            case 0:
                picUrl = "honda";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.ic_launcher_background));
                break;
            case 1:
                picUrl = "yamaha";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.ic_launcher_background));
                break;
            case 2:
                picUrl = "yamaha";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.ic_launcher_background));
                break;
            case 3:
                picUrl = "yamaha";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.ic_launcher_background));
                break;
            case 4:
                picUrl = "yamaha";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.ic_launcher_background));
                break;
        }
        int drawableRecouseId = holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",
                holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableRecouseId).into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
