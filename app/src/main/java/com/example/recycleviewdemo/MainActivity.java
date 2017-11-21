package com.example.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.example.recycleviewdemo.adapter.HomeAdapter;
import com.example.recycleviewdemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = findViewById(R.id.recycleView);

        //LinearLayout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //GridLayout
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
//        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        //StaggeredGrid
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
//        staggeredGridLayoutManager.setOrientation(StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));


        homeAdapter = new HomeAdapter(this, mDatas);
        SlideInBottomAnimationAdapter slideInBottomAnimationAdapter = new SlideInBottomAnimationAdapter(homeAdapter);
        recyclerView.setAdapter(slideInBottomAnimationAdapter);
        setLinsener();
    }

    private void setLinsener() {
        homeAdapter.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " click",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, position + " long click",
                        Toast.LENGTH_SHORT).show();
                homeAdapter.removeData(position);
            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_action_add:
                homeAdapter.addData(homeAdapter.getItemCount());
                break;
            case R.id.id_action_delete:
                if (homeAdapter.getItemCount() > 1) {
                    homeAdapter.removeData(homeAdapter.getItemCount() - 1);
                }
                break;
            default:
                break;
        }
        return true;
    }
}
