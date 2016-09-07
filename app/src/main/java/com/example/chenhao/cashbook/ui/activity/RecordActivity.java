package com.example.chenhao.cashbook.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.chenhao.cashbook.R;
import com.example.chenhao.cashbook.base.BaseActivity;

public class RecordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        initToolBar();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.record_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(onClick);
    }


}
