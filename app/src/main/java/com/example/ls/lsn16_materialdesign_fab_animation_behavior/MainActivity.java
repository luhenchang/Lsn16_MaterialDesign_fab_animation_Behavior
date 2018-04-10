package com.example.ls.lsn16_materialdesign_fab_animation_behavior;

import android.annotation.SuppressLint;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ToobarLisenner{
    MyRecylerviewAdapter madapter;
    RecyclerView mrecylerview;
    private List<String> mData;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.tl);
        mrecylerview=findViewById(R.id.rv_list);
        mData=new ArrayList<>();
         for (int i = 0; i <30 ; i++) {
            mData.add("item="+i);
        }
        madapter=new MyRecylerviewAdapter(mData,this);
        mrecylerview.setAdapter(madapter);
        mrecylerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void hide() {
        Toast.makeText(this, "赢藏", Toast.LENGTH_SHORT).show();
        toolbar.animate().translationY(-(toolbar.getHeight()+toolbar.getPaddingTop())).setInterpolator(new AccelerateInterpolator(3));
    }

    @Override
    public void visible() {
        Toast.makeText(this, "显示", Toast.LENGTH_SHORT).show();
        toolbar.animate().translationY(0).setInterpolator(new AccelerateInterpolator(3));

    }

    @SuppressLint("ResourceType")
    public void rota(View view) {
        Snackbar.make(view,"确定",Snackbar.LENGTH_LONG).setAction(R.id.fb,new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        }).show();
    }
}
