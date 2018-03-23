package com.example.a365mc_inno1.facecheckgame.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a365mc_inno1.facecheckgame.R;
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

        return view;
    }


    private void initView(){
        recyclerview = view.findViewById(R.id.recycler_staff);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(lm);
        adapter = new test2Adapter(staffList,getContext());
        recyclerview.setAdapter(adapter);
    }


}
