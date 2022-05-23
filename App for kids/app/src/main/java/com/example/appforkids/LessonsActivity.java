package com.example.appforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class LessonsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        this.findViewById(R.id.lessonsActivity_aButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_bButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_cButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_dButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_eButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_fButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_gButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_hButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_iButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_jButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_kButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_lButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_mButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_nButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_oButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_pButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_qButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_rButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_sButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_tButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_uButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_vButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_wButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_xButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_yButton).setOnClickListener(this);
        this.findViewById(R.id.lessonsActivity_zButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String alphabet = ((Button)view).getText().toString();
        Intent intent = new Intent(this, ViewAlphabetImagesActivity.class);
        intent.putExtra("alphabet", alphabet);
        this.startActivity(intent);
    }
}