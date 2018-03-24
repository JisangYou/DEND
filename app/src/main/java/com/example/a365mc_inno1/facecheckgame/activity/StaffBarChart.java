package com.example.a365mc_inno1.facecheckgame.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.model.Staff;
import com.example.a365mc_inno1.facecheckgame.util.Constant;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class StaffBarChart extends AppCompatActivity {
    BarChart barChart;
    ArrayList<Staff> data;
    Bundle bundle2;
    List<BarEntry> entries, entries2, entries3, entries4;
    BarDataSet set, set2, set3, set4;
    int n, m, f, e = 0;
    BarData barData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        barChart = (BarChart) findViewById(R.id.barchart);

        initData();


    }

    private void initData() {
        bundle2 = getIntent().getExtras();
        data = bundle2.getParcelableArrayList(Constant.DYMMY_DATA);
        entries = new ArrayList<>();
        entries2 = new ArrayList<>();
        entries3 = new ArrayList<>();
        entries4 = new ArrayList<>();


        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getDep().equals("innovation")) {
                Log.e("check1", "innovation" + n);
                n++;
            } else if (data.get(i).getDep().equals("marketing")) {
                Log.e("check2", "marketing" + m);
                m++;
            } else if (data.get(i).getDep().equals("finance")) {
                Log.e("check3", "finance" + f);
                f++;
            } else if (data.get(i).getDep().equals("executive")) {
                Log.e("check4", "executive " + e);
                e++;
            }
        }


        entries.add(new BarEntry(10, n));
        entries2.add(new BarEntry(20, m));
        entries3.add(new BarEntry(30, f));
        entries4.add(new BarEntry(40, e));
        set = new BarDataSet(entries, "innovation");
        set2 = new BarDataSet(entries2, "marketing");
        set3 = new BarDataSet(entries3, "finance");
        set4 = new BarDataSet(entries4, "executive");
        barData = new BarData(set, set2, set3, set4);
        barData.setBarWidth(5); // set custom bar width

        barChart.setData(barData);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate(); // refresh
    }
}


