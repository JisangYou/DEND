package com.example.a365mc_inno1.facecheckgame.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.adapter.RankingAdapter;
import com.example.a365mc_inno1.facecheckgame.model.User;

import java.util.List;

public class RankingActivity extends AppCompatActivity {

    RecyclerView rankingRecyclerView;
    RankingAdapter adapter;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        initView();
    }

    private void initView() {
        rankingRecyclerView = findViewById(R.id.ranking_recyclerView);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rankingRecyclerView.setLayoutManager(lm);
        adapter = new RankingAdapter(this, users);
        rankingRecyclerView.setAdapter(adapter);
    }
}
