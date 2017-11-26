package com.example.fatimamostafa.roomarchitecture;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    @BindView(R.id.rvMetrics)
    RecyclerView rvMetrics;
    private MetricsListViewModel viewModel;
    private MetricsAdapter metricsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        metricsAdapter = new MetricsAdapter(new ArrayList<MetricsModel>(), this);
        rvMetrics.setLayoutManager(new LinearLayoutManager(this));

        rvMetrics.setAdapter(metricsAdapter);

        viewModel = ViewModelProviders.of(this).get(MetricsListViewModel.class);

        viewModel.getItemAndMetricsList().observe(MainActivity.this, new Observer<List<MetricsModel>>() {
            @Override
            public void onChanged(@Nullable List<MetricsModel> metricsModels) {
                metricsAdapter.addItems(metricsModels);
            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
        MetricsModel metricsModel = (MetricsModel) view.getTag();
        viewModel.deleteItem(metricsModel);
        return true;
    }

    @OnClick(R.id.btnAddActivity)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, AddActivity.class));
    }
}
