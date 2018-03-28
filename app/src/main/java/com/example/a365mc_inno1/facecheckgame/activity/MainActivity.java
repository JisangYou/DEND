package com.example.a365mc_inno1.facecheckgame.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a365mc_inno1.facecheckgame.CustomViewPager;
import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.adapter.ViewPagerAdapter;

import com.example.a365mc_inno1.facecheckgame.model.Staff;
import com.example.a365mc_inno1.facecheckgame.util.Constant;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    CustomViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    List<Staff> staffList, tempList;
    int current = -1;
    int count = 10;
    TextView textCountDown, textName;
    int[] randomeIdx;
    Button btnTrue, btnFalse;
    LinearLayout layoutox;
    SeekBar seekbar_progress;
    countTimer countTimer;
    int point = 0;
    String name_OX;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDummyDB();
        tempList = new ArrayList<>();

        timer();
        initRandom();
        initView();
        initViewpager();

    }

    // -----------------------------------------------------------------------------------------------------------
    //
    //                                              initDummy
    //
    // -----------------------------------------------------------------------------------------------------------

    private void initDummyDB() {

        staffList = getIntent().getParcelableArrayListExtra(Constant.DYMMY_DATA);
        Log.e("check", "hh" + staffList.size());
//        staffList.add(new Staff("김영삼", R.drawable.kim_executive, 0, "남", Constant.EXE));
//        staffList.add(new Staff("홍성진", R.drawable.hong_executive, 1, "남", Constant.EXE));
//        staffList.add(new Staff("박서이", R.drawable.park_marketing, 2, "여", Constant.MAR));
//        staffList.add(new Staff("만산", R.drawable.man_marketing, 3, "여", Constant.MAR));
//        staffList.add(new Staff("임금희", R.drawable.lim_marketing, 4, "여", Constant.MAR));
//        staffList.add(new Staff("허설", R.drawable.husul_inno, 5, "남", Constant.INNO));
//        staffList.add(new Staff("김혜란", R.drawable.kim_design, 6, "여", Constant.DIS));
//        staffList.add(new Staff("방주현", R.drawable.bang_design, 7, "여", Constant.DIS));
//        staffList.add(new Staff("추지아", R.drawable.chu_design, 8, "여", Constant.DIS));
//        staffList.add(new Staff("박준서", R.drawable.park_com, 9, "남", Constant.COM));
//        staffList.add(new Staff("허인영", R.drawable.huh_com, 10, "여", Constant.COM));
//        staffList.add(new Staff("곽미리", R.drawable.gwak_com, 11, "여", Constant.COM));
//        for (int i = 0; i < staffList.size(); i++) {
//            mConditionRef = mDatabase.child(staffList.get(i).getIndex() + "");
//            mConditionRef.setValue(staffList.get(i));
//            Log.e("check", "  ====   " + staffList.get(i));
//        }

    }

    // -----------------------------------------------------------------------------------------------------------
    //
    //                                              initView
    //
    // -----------------------------------------------------------------------------------------------------------

    private void initView() {
        btnTrue = findViewById(R.id.btn_true);
        btnFalse = findViewById(R.id.btn_false);
        textName = findViewById(R.id.text_name);
        viewPager = findViewById(R.id.viewpager);
        textCountDown = findViewById(R.id.text_countTimer);
        layoutox = findViewById(R.id.layout_ox);
        seekbar_progress = findViewById(R.id.seekBar_progress);
        seekbar_progress.setMax(staffList.size() - 1);
        initChangeList();
    }

    // -----------------------------------------------------------------------------------------------------------
    //
    //                                              initSetOX
    //
    // -----------------------------------------------------------------------------------------------------------

    private void initSetOX() {
        name_OX = tempList.get(current).getName();
        textName.setText(tempList.get(randomeIdx[current]).getName());
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name_OX.equals(tempList.get(randomeIdx[current]).getName())) {
                    point++;
                    currentState();
                    viewPager.setCurrentItem(current + 1);
                } else
                    failedState();
            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(name_OX.equals(tempList.get(randomeIdx[current]).getName()))) {
                    point++;
                    currentState();
                    viewPager.setCurrentItem(current + 1);
                } else
                    failedState();
            }
        });
    }

//    private void getData() {
//
//
//        mConditionRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//
//                    Staff staff = snapshot.getValue(Staff.class);
//                    staffList.add(staff);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        for (int i = 0; i < staffList.size(); i++) {
//            Log.e("mainActivity", "mainActivity   =====  " + staffList.get(i).getName());
//        }
//
//    }
    // -----------------------------------------------------------------------------------------------------------
    //
    //                                              initViewpager
    //
    // -----------------------------------------------------------------------------------------------------------

    public void initViewpager() {

        viewPagerAdapter = new ViewPagerAdapter(this, tempList);
        viewPager.setPagingEnabled(false);
        viewPager.setAdapter(viewPagerAdapter);
        current = 0;
        viewPager.setCurrentItem(current);
        initSetOX();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                current = position;

                countTimer.setStop();
                initSetOX();

                count = 5;
                timer();
                seekbar_progress.setProgress(position);
                if (current == tempList.size() - 1) {
                    currentState();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // -----------------------------------------------------------------------------------------------------------
    //
    //                                              timer관련 Handler
    //
    // -----------------------------------------------------------------------------------------------------------
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);

            switch (msg.what) {
                case Constant.ACTION_SET:

                    if (count > 0) {
                        textCountDown.setText(String.valueOf(count));
                        count--;
                    } else {
                        textCountDown.setText("the end");
                        failedState();
                    }
                    break;
            }
        }
    };


    private void timer() {
        countTimer = new countTimer(handler);
        countTimer.start();
    }


    // -----------------------------------------------------------------------------------------------------------
    //
    //                                              random함수 및 list 변환
    //
    // -----------------------------------------------------------------------------------------------------------

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

    private void initChangeList() {

        for (int i = 0; i < staffList.size(); i++) {
            tempList.add(staffList.get(randomeIdx[i]));
        }

    }


    private void currentState() {
        countTimer.setStop();
        Toast.makeText(this, point + " Combo", Toast.LENGTH_SHORT).show();

    }

    private void failedState() {
        countTimer.setStop();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_failed, null, false);
        builder.setView(view).show();

        view.findViewById(R.id.btn_failed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

    }

}

// -----------------------------------------------------------------------------------------------------------
//
//                                              timer관련 Thread 클래스
//
// -----------------------------------------------------------------------------------------------------------

class countTimer extends Thread {
    Handler handler;
    Boolean RUNNING = true;

    public countTimer(Handler handler) {
        this.handler = handler;
    }

    public void run() {
        while (RUNNING) {
            Message msg = new Message();
            msg.what = Constant.ACTION_SET;
            handler.sendMessage(msg);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStop() {
        RUNNING = false;
    }


}