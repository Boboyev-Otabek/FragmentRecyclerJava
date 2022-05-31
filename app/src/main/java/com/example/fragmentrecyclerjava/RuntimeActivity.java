package com.example.fragmentrecyclerjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragmentrecyclerjava.Fragment.FirstFragment;
import com.example.fragmentrecyclerjava.Fragment.SecondFragment;

public class RuntimeActivity extends AppCompatActivity implements FirstFragment.FirstListener {

    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime);
        initView();
    }

    @Override
    public void onFirstSend(String str) {
        secondFragment.updateSecondText(str);
    }

    void initView() {
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        getSupportFragmentManager().beginTransaction().
                replace(R.id.firstfragnent, firstFragment).
                replace(R.id.secondfragment, secondFragment).commit();

    }
}