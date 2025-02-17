package com.example.md_lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.ViewHolder> {

    private List<Mobile> mobiles;
    private Context context;

    public MobileAdapter(Context context, List<Mobile> mobiles) {
        this.context = context;
        this.mobiles = mobiles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.mobile_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(mobiles.get(position).getImage());
        holder.name.setText(mobiles.get(position).getName());
        holder.description.setText(mobiles.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return mobiles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imv_mobile);
            name = itemView.findViewById(R.id.tv_mobile_name);
            description = itemView.findViewById(R.id.tv_description);
        }
    }
}
