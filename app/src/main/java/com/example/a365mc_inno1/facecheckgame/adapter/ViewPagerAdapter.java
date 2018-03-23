package com.example.a365mc_inno1.facecheckgame.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.model.Staff;

import java.util.List;

/**
 * Created by 365mc_inno1 on 2018-03-21.
 */

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    List<Staff> data;


    public ViewPagerAdapter(Context context, List<Staff> data) {
        this.context = context;
        this.data = data;
        Log.e("check", "check data" + data.size());
    }

    @Override
    public int getCount() {
        return data.size();
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item, null);
        Staff url = data.get(position);

        ImageView img_staff = view.findViewById(R.id.img_staff);
        Glide.with(context).load(url.getUrl()).into(img_staff);


        container.addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}





























