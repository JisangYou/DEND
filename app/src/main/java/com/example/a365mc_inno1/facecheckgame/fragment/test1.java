package com.example.a365mc_inno1.facecheckgame.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a365mc_inno1.facecheckgame.R;

import com.example.a365mc_inno1.facecheckgame.adapter.ViewPagerAdapter;
import com.example.a365mc_inno1.facecheckgame.model.Staff;
import com.example.a365mc_inno1.facecheckgame.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class test1 extends Fragment {
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    View view;
    Bundle bundle;
    List<Staff> staffList, tempList;
    TextView editName;
    int current = -1;
    int count;
    TextView textCountDown;
    int[] randomeIdx;
    Button btn1, btn2, btn3, btn4;
    CountDownTimer countDown = null;


    public test1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_test1, container, false);

        bundle = getArguments();
        staffList = bundle.getParcelableArrayList(Constant.DYMMY_DATA);
        tempList = new ArrayList<>();

        initRandom();
        initView();

        initViewpager();

        timer();

        return view;
    }

    private void initView() {
        viewPager = view.findViewById(R.id.viewpager);
        editName = view.findViewById(R.id.edit_name);
        textCountDown = view.findViewById(R.id.text_countTimer);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        initChangeList();

    }

    public void initViewpager() {

        viewPagerAdapter = new ViewPagerAdapter(getContext(), tempList);
        viewPager.setAdapter(viewPagerAdapter);
        current = 0;
        viewPager.setCurrentItem(current);
        Log.e("current", "check current setCurrentItem == " + current);
        initSetButton(current);
        btnClick();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                current = position;
                Log.e("current", "check current onPageSelected == " + current);
                initSetButton(current);
                btnClick();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void timer() {

        count = 60;
        countDown = new CountDownTimer(10 * 6000, 1000) {
            @Override
            public void onTick(long mili) {
                textCountDown.setText(String.valueOf(count));
                count--;
                Log.e("onTick", "시간이 흐른다!");
            }

            @Override
            public void onFinish() {
                Log.e("onFinish", "시간이 멈춘다!");
                textCountDown.setText(String.valueOf("the end!"));
            }
        }.start();
    }


    private int[] initRandom() {


        Random random = new Random();
        randomeIdx = new int[staffList.size()];
        for (int i = 0; i < randomeIdx.length; i++) {
            randomeIdx[i] = random.nextInt(randomeIdx.length);
            for (int j = 0; j < i; j++) {
                if (randomeIdx[i] == randomeIdx[j]) {
                    i--;
                    break;
                }
            }
        }

        return randomeIdx;
    }

    private void initSetButton(int current) {
        Log.e("current", "check current initSetButton == " + current);

        if (current == 0) {
            btn1.setText(tempList.get(0).getName());
            btn2.setText(tempList.get(1).getName());
            btn3.setText(tempList.get(2).getName());
            btn4.setText(tempList.get(3).getName());
        } else if (current == 1) {
            btn1.setText(tempList.get(1).getName());
            btn2.setText(tempList.get(2).getName());
            btn3.setText(tempList.get(0).getName());
            btn4.setText(tempList.get(4).getName());
        } else if (current == 2) {
            btn1.setText(tempList.get(2).getName());
            btn2.setText(tempList.get(0).getName());
            btn3.setText(tempList.get(1).getName());
            btn4.setText(tempList.get(3).getName());
        } else if (current == 3) {
            btn1.setText(tempList.get(4).getName());
            btn2.setText(tempList.get(1).getName());
            btn3.setText(tempList.get(3).getName());
            btn4.setText(tempList.get(2).getName());
        } else if (current == 4) {
            btn1.setText(tempList.get(3).getName());
            btn2.setText(tempList.get(1).getName());
            btn3.setText(tempList.get(2).getName());
            btn4.setText(tempList.get(4).getName());
        } else if (current == 5) {
            btn1.setText(tempList.get(1).getName());
            btn2.setText(tempList.get(3).getName());
            btn3.setText(tempList.get(5).getName());
            btn4.setText(tempList.get(2).getName());
        }


    }

    private void initChangeList() {

        for (int i = 0; i < staffList.size(); i++) {
            tempList.add(staffList.get(randomeIdx[i]));
        }

    }

    String text1, text2, text3, text4;

    private void btnClick() {
        text1 = btn1.getText().toString();
        text2 = btn2.getText().toString();
        text3 = btn3.getText().toString();
        text4 = btn4.getText().toString();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text1.equals(tempList.get(current).getName())) {

                    Toast.makeText(getContext(), "정답입니다!!!!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "땡떙땡!!!!", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text2.equals(tempList.get(current).getName())) {

                    Toast.makeText(getContext(), "정답입니다!!!!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "땡떙땡!!!!", Toast.LENGTH_SHORT).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text3.equals(tempList.get(current).getName())) {

                    Toast.makeText(getContext(), "정답입니다!!!!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "땡떙땡!!!!", Toast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text4.equals(tempList.get(current).getName())) {

                    Toast.makeText(getContext(), "정답입니다!!!!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getContext(), "땡떙땡!!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

