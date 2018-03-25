package com.example.a365mc_inno1.facecheckgame.fragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a365mc_inno1.facecheckgame.R;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class test3 extends Fragment implements Button.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btnReset;
    View view;
    EditText edit_prop;
    int num;
    double count = 0;

    public test3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_test3, container, false);
        initView();
        initListener();
        randomEvent();

        return view;
    }

    private void initView() {
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        btn5 = view.findViewById(R.id.btn5);
        btn6 = view.findViewById(R.id.btn6);
        btn7 = view.findViewById(R.id.btn7);
        btn8 = view.findViewById(R.id.btn8);
        btn9 = view.findViewById(R.id.btn9);
        btn10 = view.findViewById(R.id.btn10);
        btn11 = view.findViewById(R.id.btn11);
        btn12 = view.findViewById(R.id.btn12);
        btn13 = view.findViewById(R.id.btn13);
        btn14 = view.findViewById(R.id.btn14);
        btn15 = view.findViewById(R.id.btn15);
        btn16 = view.findViewById(R.id.btn16);
        btn17 = view.findViewById(R.id.btn17);
        btn18 = view.findViewById(R.id.btn18);
        btn19 = view.findViewById(R.id.btn19);
        btn20 = view.findViewById(R.id.btn20);
        btnReset = view.findViewById(R.id.btnReset);
        edit_prop = view.findViewById(R.id.edit_prop);
    }

    private void initListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }


    private void randomEvent() {
        Random random = new Random();
        num = random.nextInt(20) + 1;
        Log.e("num", "num  =  " + num);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                if (num == 1) {
                    toastSetting();
                } else {
                    btn1.setVisibility(View.INVISIBLE);
                    setEdit();

                }
                break;
            case R.id.btn2:
                if (num == 2) {
                    toastSetting();
                } else {
                    btn2.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn3:
                if (num == 3) {
                    toastSetting();
                } else {
                    btn3.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn4:
                if (num == 4) {
                    toastSetting();
                } else {
                    btn4.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn5:
                if (num == 5) {
                    toastSetting();
                } else {
                    btn5.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn6:
                if (num == 6) {
                    toastSetting();
                } else {
                    btn6.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn7:
                if (num == 7) {
                    toastSetting();
                } else {
                    btn7.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn8:
                if (num == 8) {
                    toastSetting();
                } else {
                    btn8.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn9:
                if (num == 9) {
                    toastSetting();
                } else {
                    btn9.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn10:
                if (num == 10) {
                    toastSetting();
                } else {
                    btn10.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn11:
                if (num == 11) {
                    toastSetting();
                } else {
                    btn11.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn12:
                if (num == 12) {
                    toastSetting();
                } else {
                    btn12.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn13:
                if (num == 13) {
                    toastSetting();
                } else {
                    btn13.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn14:
                if (num == 14) {
                    toastSetting();
                } else {
                    btn14.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn15:
                if (num == 15) {
                    toastSetting();
                } else {
                    btn15.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn16:
                if (num == 16) {
                    toastSetting();
                } else {
                    btn16.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn17:
                if (num == 17) {
                    toastSetting();
                } else {
                    btn17.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn18:
                if (num == 18) {
                    toastSetting();
                } else {
                    btn18.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn19:
                if (num == 19) {
                    toastSetting();
                } else {
                    btn19.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btn20:
                if (num == 20) {
                    toastSetting();
                } else {
                    btn20.setVisibility(View.INVISIBLE);
                    setEdit();
                }
                break;
            case R.id.btnReset:
                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
                btn7.setVisibility(View.VISIBLE);
                btn8.setVisibility(View.VISIBLE);
                btn9.setVisibility(View.VISIBLE);
                btn10.setVisibility(View.VISIBLE);
                btn11.setVisibility(View.VISIBLE);
                btn12.setVisibility(View.VISIBLE);
                btn13.setVisibility(View.VISIBLE);
                btn14.setVisibility(View.VISIBLE);
                btn15.setVisibility(View.VISIBLE);
                btn16.setVisibility(View.VISIBLE);
                btn17.setVisibility(View.VISIBLE);
                btn18.setVisibility(View.VISIBLE);
                btn19.setVisibility(View.VISIBLE);
                btn20.setVisibility(View.VISIBLE);
                randomEvent();
                count = 0;
                edit_prop.setText(0 + " % ");
        }
    }

    private void toastSetting() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_pause, null, false);
        builder.setView(view).show();
    }

    @SuppressLint("SetTextI18n")
    private void setEdit() {
        count++;
        edit_prop.setText(100 * (1 / (20 - count)) + " % ");
    }
}
