package com.example.fatimamostafa.roomarchitecture;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fatimamostafa on 11/26/17.
 */

public class MetricsAdapter extends RecyclerView.Adapter<MetricsAdapter.RecyclerViewHolder> {



    private List<MetricsModel> metricsModelList;
    private View.OnLongClickListener longClickListener;

    public MetricsAdapter(List<MetricsModel> metricsModelsList, View.OnLongClickListener longClickListener) {
        this.metricsModelList = metricsModelsList;
        this.longClickListener = longClickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_metrics_model, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        MetricsModel metricsModel = metricsModelList.get(position);
        holder.tvTitle.setText(metricsModel.getMetricsTitle());
        holder.tvScore.setText(metricsModel.getMetricsValue());
        holder.tvDate.setText(metricsModel.getBorrowDate().toLocaleString().substring(0, 11));
        holder.itemView.setTag(metricsModel);
        holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return metricsModelList.size();
    }

    public void addItems(List<MetricsModel> metricsModelList) {
        this.metricsModelList = metricsModelList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvScore)
        TextView tvScore;
        @BindView(R.id.tvDate)
        TextView tvDate;

        RecyclerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
