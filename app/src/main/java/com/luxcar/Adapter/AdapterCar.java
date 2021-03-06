package com.luxcar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.luxcar.R;
import com.luxcar.models.entities.Car;

import java.util.ArrayList;

public class AdapterCar extends RecyclerView.Adapter<AdapterCar.ViewHolder> {

    ArrayList<Car> cars;

    public AdapterCar(ArrayList<Car> Cars) {
        this.cars = Cars;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.acctivity_home_custom_item_car,parent,false);

        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tittle.setText(cars.get(position).getName());
        holder.fee.setText(String.valueOf(cars.get(position).getPrice()));

        int drawableRecouseId = holder.itemView.getContext().getResources().getIdentifier(String.valueOf(cars.get(position).getPhoto()),"drawable",
                holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableRecouseId).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tittle, fee;
        ImageView pic;
        TextView addBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tittle = itemView.findViewById(R.id.tittle);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
