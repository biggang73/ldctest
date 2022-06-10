package com.fish.ab.app.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fish.ab.R;
import com.fish.ab.app.bean.ProjectInfo;
import com.fish.ab.app.bean.adapter.RecyclerAdapter;
import com.fish.ab.app.vm.BaseTitleViewModel;
import com.fish.ab.app.vm.FsuDetailViewModel;
import com.fish.ab.base.vm.BaseActivity;
import com.fish.ab.databinding.ActivityFsudetailviewBinding;

import java.util.ArrayList;

public class FsuDetailViewActivity extends BaseActivity<FsuDetailViewModel, ActivityFsudetailviewBinding> {

    private String TAG = "FsuDetailViewActivity";

    private ArrayList<ProjectInfo> info_list;

    private RecyclerAdapter.RecyclerViewClickListener listener;


    private String id;

    public static void start(Context context) {
        Intent intent = new Intent(context, FsuDetailViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int onCreate() {
        return R.layout.activity_fsudetailview;
    }

    @Override
    protected FsuDetailViewModel initViewModel() {
        return new ViewModelProvider(this).get(FsuDetailViewModel.class);
    }

    @Override
    protected BaseTitleViewModel initTitleVM() {
        return null;
    }

    //页面绑定方法
    public void getFsuData(View view) {
        //调用逻辑
        viewModel.getFsuData("1", "100082", "1", "1", "SystemAdmin", "2");
    }

    @Override
    protected void showError(Object obj) {

        info_list = (ArrayList<ProjectInfo>) obj;

        if (info_list != null) {
//            Toast.makeText(MyApplication.CONTEXT, "回到FsuDetailViewActivity了", Toast.LENGTH_LONG).show();
//            MainBAOANActivity.start(FsuDetailViewActivity.this);
//            finish();
            setAdapter();
        }
    }

    public void setAdapter() {
//        setOnClickListener(); /* 这一行必须摆在这里 不能摆在下面一段的下面*/

        RecyclerAdapter adapter = new RecyclerAdapter(info_list, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        dataBinding.recyclerview.setLayoutManager(layoutManager);
        dataBinding.recyclerview.setItemAnimator(new DefaultItemAnimator());
        dataBinding.recyclerview.setAdapter(adapter);
    }

//    public void setOnClickListener() {
//        listener = new Adapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View v, int position) {
//
//            }
//        };
//    }

    @Override
    protected void initView() {
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            id = extras.getString("id");
//            Toast.makeText(MyApplication.CONTEXT, "拿到了", Toast.LENGTH_LONG).show();
        }

        viewModel.getFsuData("1", id, "1", "1", "SystemAdmin", "2");
    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);
    }


    @Override
    protected void getBack(Object obj) {

    }

    @Override
    protected void getMenu(Object obj) {

    }
}
