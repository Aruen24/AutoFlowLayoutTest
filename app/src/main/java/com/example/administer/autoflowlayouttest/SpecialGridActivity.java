package com.example.administer.autoflowlayouttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.Arrays;

public class SpecialGridActivity extends AppCompatActivity {

    private AutoFlowLayout mFlowLayout;
    private LayoutInflater mLayoutInflater;
    private String[] mData = {"Java", "C++", "Python", "JavaScript", "Ruby", "Swift","Swift","MATLAB","Scratch"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_grid);
        mLayoutInflater = LayoutInflater.from(this);
        mFlowLayout = (AutoFlowLayout) findViewById(R.id.afl_cotent);
        mFlowLayout.setAdapter(new FlowAdapter(Arrays.asList(mData)) {
            @Override
            public View getView(int position) {
                View item = mLayoutInflater.inflate(R.layout.special_grid_item, null);
                return item;
            }
        });
    }
}
