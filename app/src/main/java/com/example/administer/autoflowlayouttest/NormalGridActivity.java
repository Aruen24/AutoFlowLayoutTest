package com.example.administer.autoflowlayouttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.Arrays;

public class NormalGridActivity extends AppCompatActivity implements View.OnClickListener {

    private AutoFlowLayout mFlowLayout;
    private LayoutInflater mLayoutInflater;
    private Button mAddButton;
    private Button mDeleteButton;
    private int count = 6;
    private String[] mData = {"Java", "C++", "Python", "JavaScript", "Ruby", "Swift"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_grid);
        mFlowLayout = (AutoFlowLayout) findViewById(R.id.afl_cotent);
        mLayoutInflater = LayoutInflater.from(this);
        mAddButton = (Button) findViewById(R.id.bt_add);
        mDeleteButton = (Button) findViewById(R.id.bt_delete);
        mAddButton.setOnClickListener(this);
        mDeleteButton.setOnClickListener(this);
        mFlowLayout.setAdapter(new FlowAdapter(Arrays.asList(mData)) {
            @Override
            public View getView(int position) {
                View item = mLayoutInflater.inflate(R.layout.grid_item, null);
//                TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
//                tvAttrTag.setText(mData[position]);
                return item;
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add:{
                count++;
                mFlowLayout.setRowNumbers(count%3 == 0 ? count/3 : count/3 + 1);
                View item = mLayoutInflater.inflate(R.layout.grid_item, null);
                mFlowLayout.addView(item);
                break;
            }
            case R.id.bt_delete:{
                count--;
                mFlowLayout.setRowNumbers(count%3 == 0 ? count/3 : count/3 + 1);
                mFlowLayout.deleteView();
                break;
            }

        }
    }
}
