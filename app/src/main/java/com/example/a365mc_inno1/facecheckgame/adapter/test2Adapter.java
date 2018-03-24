package com.example.a365mc_inno1.facecheckgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.model.Staff;

import java.util.List;

/**
 * Created by 365mc_inno1 on 2018-03-23.
 */

public class test2Adapter extends RecyclerView.Adapter<test2Adapter.Holder> {

    List<Staff> data;
    Context context;

    public test2Adapter(List<Staff> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.test2_item, parent, false);


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Staff staff = data.get(position);
        holder.editName.setText(staff.getName());
        holder.editDep.setText(staff.getDep());
        holder.editSex.setText(staff.getSex());
        Glide.with(context).load(staff.getUrl()).apply(RequestOptions.centerCropTransform()).into(holder.imgStaff);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView imgStaff;
        TextView editName;
        TextView editDep;
        TextView editSex;


        public Holder(View itemView) {
            super(itemView);
            imgStaff = itemView.findViewById(R.id.img_staff);
            editName = itemView.findViewById(R.id.edit_name);
            editDep = itemView.findViewById(R.id.edit_dep);
            editSex = itemView.findViewById(R.id.edit_sex);
        }
    }
}

