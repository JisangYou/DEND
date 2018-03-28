package com.example.a365mc_inno1.facecheckgame.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.a365mc_inno1.facecheckgame.R;
import com.example.a365mc_inno1.facecheckgame.model.Staff;
import com.example.a365mc_inno1.facecheckgame.util.Constant;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageReference;

    ImageView imgSplash;
    List<Staff> staffList;
    List<String> imgUrl;
    Button btnStart, btnRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        initSplash();
        initMove();
        getData();

    }


    private void initView() {
        imgSplash = findViewById(R.id.img_splash);
        btnStart = findViewById(R.id.btn_start);
        btnRanking = findViewById(R.id.btn_ranking);
    }

    private void initSplash() {
        Glide.with(this).load(R.raw.splash).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE)).into(imgSplash);
    }

    Intent intent1, intent2;

    private void initMove() {

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1 = new Intent(SplashActivity.this, MainActivity.class);
                intent1.putParcelableArrayListExtra(Constant.DYMMY_DATA, (ArrayList<? extends Parcelable>) staffList);
                Log.e("mainActivity2", "mainActivity2   =====  " + staffList.size());
                startActivity(intent1);
            }
        });
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent2 = new Intent(SplashActivity.this, RankingActivity.class);
                startActivity(intent2);
            }
        });
    }

    private void getData() {

        staffList = new ArrayList<>();

        mConditionRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Staff staff = snapshot.getValue(Staff.class);
                    staffList.add(staff);
                    Log.e("mainActivity", "mainActivity   =====  " + staffList.size());
                }
                getImgData();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void getImgData() {
        storageReference = storage.getReferenceFromUrl("gs://mlfirebaseproject-b2bad.appspot.com");

        for (int i = 0; i < staffList.size(); i++) {
            storageReference.child(staffList.get(i).getUrl()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {


                    Log.e("storageReference", "storageReference   =====  " + uri);
                }
            });
        }
    }

}
