package com.example.chenhao.cashbook.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by chenhao on 2016/9/6.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


    }

    protected View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

}
