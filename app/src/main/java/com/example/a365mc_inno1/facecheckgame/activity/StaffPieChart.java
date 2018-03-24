package com.example.a365mc_inno1.facecheckgame.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.model.Staff;
import com.example.a365mc_inno1.facecheckgame.util.Constant;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class StaffPieChart extends AppCompatActivity {
    PieChart pieChart;
    ArrayList<Staff> data;
    ArrayList<PieEntry> yValues;
    Bundle bundle2;
    int manCount, womanCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_piechart);
        initData();
        initView();
        initSetting();
        initAnimation();


    }

    private void initView() {
        pieChart = (PieChart) findViewById(R.id.piechart);
    }

    private void initSetting() {
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);
        Description description = new Description();
        description.setText("365mc네트웍스 성비"); //라벨
        description.setTextSize(15);
        pieChart.setDescription(description);


        PieDataSet dataSet = new PieDataSet(yValues, "성비");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
    }

    private void initAnimation() {
        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션
    }


    public void initData() {

        bundle2 = getIntent().getExtras();
        data = bundle2.getParcelableArrayList(Constant.DYMMY_DATA);
        yValues = new ArrayList<PieEntry>();

        Log.e("bundle", "bundle check2 === " + data);

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getSex().equals("남")) {
                manCount++;
            } else
                womanCount++;
        }
        yValues.add(new PieEntry(manCount, "남자"));
        yValues.add(new PieEntry(womanCount, "여자"));

    }
}
