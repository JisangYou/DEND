package com.example.a365mc_inno1.facecheckgame.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.activity.StaffBarChart;
import com.example.a365mc_inno1.facecheckgame.activity.StaffPieChart;
import com.example.a365mc_inno1.facecheckgame.adapter.test2Adapter;
import com.example.a365mc_inno1.facecheckgame.model.Staff;
import com.example.a365mc_inno1.facecheckgame.util.Constant;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class test2 extends Fragment {

    RecyclerView recyclerview;
    test2Adapter adapter;
    List<Staff> staffList;
    View view;
    Bundle bundle;
    Button button, button2;

    public test2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_test2, container, false);
        bundle = getArguments();
        staffList = bundle.getParcelableArrayList(Constant.DYMMY_DATA);

        initView();
        buttonClick();
        initRecycler();

        return view;
    }

    private void initView() {
        recyclerview = view.findViewById(R.id.recycler_staff);
        button = view.findViewById(R.id.button);
        button2 = view.findViewById(R.id.button2);
    }


    private void initRecycler() {

        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(lm);
        adapter = new test2Adapter(staffList, getContext());
        recyclerview.setAdapter(adapter);
    }

    private void buttonClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StaffPieChart.class);
                bundle.putParcelableArrayList(Constant.DYMMY_DATA, (ArrayList<? extends Parcelable>) staffList);
                intent.putExtras(bundle);
                getContext().startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StaffBarChart.class);
                bundle.putParcelableArrayList(Constant.DYMMY_DATA, (ArrayList<? extends Parcelable>) staffList);
                intent.putExtras(bundle);
                Log.e("bundle", "bundle check1 === " + bundle);
                getContext().startActivity(intent);
            }
        });
    }


}
