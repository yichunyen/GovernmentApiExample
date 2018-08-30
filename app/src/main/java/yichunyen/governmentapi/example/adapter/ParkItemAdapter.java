package yichunyen.governmentapi.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import yichunyen.governmentapi.example.R;

/**
 * Created by yichun on 8/28/18.
 */

public class ParkItemAdapter extends RecyclerView.Adapter<ParkItemAdapter.ParkItemViewHolder> {
    private ArrayList<ParkItem> list;

    public ParkItemAdapter() {

    }

    public void updateData(ArrayList<ParkItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ParkItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_park, parent, false);
        return new ParkItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ParkItemViewHolder holder, int position) {
        holder.setupData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ParkItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView tvParkName;
        private TextView tvName;
        private View viewDiver;

        public ParkItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_park_image);
            tvParkName = itemView.findViewById(R.id.item_park_park_name);
            tvName = itemView.findViewById(R.id.item_park_name);
            viewDiver = itemView.findViewById(R.id.item_park_diver);
        }

        public void setupData(ParkItem item) {
            Glide.with(imageView.getContext())
                    .load(item.getUrl())
                    .centerCrop()
                    .into(imageView);
            tvParkName.setText(item.getParkName());
            tvName.setText(item.getName());
            viewDiver.setVisibility(getAdapterPosition() == getItemCount() - 1 ? View.GONE : View.VISIBLE);
        }
    }
}
