package com.example.a365mc_inno1.facecheckgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.model.User;

import java.util.List;

/**
 * Created by 365mc_inno1 on 2018-03-28.
 */

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.Holder> {

    Context context;
    List<User> data;

    public RankingAdapter(Context context, List<User> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.member_ranking_item, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        User user = data.get(position);
        holder.textNickname.setText(user.getNickname());
        holder.textPoint.setText(user.getPoint());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textNickname, textPoint;

        public Holder(View itemView) {
            super(itemView);
            textNickname = itemView.findViewById(R.id.text_nickname);
            textPoint = itemView.findViewById(R.id.text_point);
        }
    }
}















