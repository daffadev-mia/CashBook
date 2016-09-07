package com.example.chenhao.cashbook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.chenhao.cashbook.R;
import com.example.chenhao.cashbook.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mContent;
    private GridView mGridView;
    private GridAdapter mGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        initId();
        initViewData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(onClick);
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_setting:
                    break;
            }
            return false;
        }
    };
    private TextView mRecord;

    private void initId() {
        mContent = (LinearLayout) findViewById(R.id.app_content);
        mGridView = (GridView) findViewById(R.id.gridView);

        mRecord = (TextView) findViewById(R.id.app_record);
        mRecord.setOnClickListener(this);


    }

    private void initViewData() {
        int mHeight = getWindowManager().getDefaultDisplay().getHeight();
        ViewGroup.LayoutParams lp = mContent.getLayoutParams();
        lp.height = (int) (mHeight / 10 * 6.5);
        mContent.setLayoutParams(lp);

        mGridAdapter = new GridAdapter(this);
        mGridView.setAdapter(mGridAdapter);
    }

    private Intent mIntent;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.app_record:
                mIntent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(mIntent);
            default:
                break;
        }
    }

    class GridData {
        public String title;
        public int icon;

        public GridData(String title, int icon) {
            this.title = title;
            this.icon = icon;
        }
    }


    class GridAdapter extends BaseAdapter {
        private List<GridData> mGridData;
        private LayoutInflater mLayoutInflater;

        public GridAdapter(Context mContext) {
            mGridData = new ArrayList<>();
            mGridData.add(new GridData("各月预算", R.mipmap.ic_launcher));
            mGridData.add(new GridData("账单统计", R.mipmap.ic_launcher));
            mGridData.add(new GridData("现金", R.mipmap.ic_launcher));

            mLayoutInflater = LayoutInflater.from(mContext);

        }


        @Override
        public int getCount() {
            return mGridData.size();
        }

        @Override
        public Object getItem(int i) {
            return mGridData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view == null) {
                holder = new ViewHolder();
                view = mLayoutInflater.inflate(R.layout.grid_item1, null);
                holder.img = (ImageView) view.findViewById(R.id.grid_item1_img);
                holder.text = (TextView) view.findViewById(R.id.grid_item1_text);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            GridData tempData = mGridData.get(i);
            holder.img.setBackgroundResource(tempData.icon);
            holder.text.setText(tempData.title);
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public TextView text;
        }

    }
}
