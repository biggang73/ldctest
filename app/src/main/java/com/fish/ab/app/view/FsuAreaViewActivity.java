package com.fish.ab.app.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fish.ab.R;
import com.fish.ab.app.bean.ProjectInfo;
import com.fish.ab.app.bean.adapter.RecyclerAdapter;
import com.fish.ab.app.vm.BaseTitleViewModel;
import com.fish.ab.app.vm.FsuAreaViewModel;
import com.fish.ab.base.vm.BaseActivity;
import com.fish.ab.databinding.ActivityFsuareaviewBinding;

import java.util.ArrayList;

public class FsuAreaViewActivity extends BaseActivity<FsuAreaViewModel, ActivityFsuareaviewBinding> {

    private String TAG = "FsuAreaViewActivity";

    private ArrayList<ProjectInfo> project_list;

    private RecyclerAdapter.RecyclerViewClickListener listener;

    public static void start(Context context) {
        Intent intent = new Intent(context, FsuAreaViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int onCreate() {
        // 绑定页面数据
        return R.layout.activity_fsuareaview;
    }

    @Override
    protected FsuAreaViewModel initViewModel() {
        return new ViewModelProvider(this).get(FsuAreaViewModel.class);
    }

    @Override
    protected BaseTitleViewModel initTitleVM() {
        return null;
    }


    //页面绑定方法
    public void getFsuData(View view) {
        //调用逻辑
        viewModel.getFsuData("0", "1", "1", "1", "SystemAdmin", "2");
    }

    @Override
    protected void showError(Object obj) {

        project_list = (ArrayList<ProjectInfo>) obj;

        if (project_list != null) {
//            Toast.makeText(MyApplication.CONTEXT, "回到FsuDetailViewActivity了", Toast.LENGTH_LONG).show();
//            MainBAOANActivity.start(FsuDetailViewActivity.this);
//            finish();
            setAdapter();
        }
    }

    public void setAdapter() {
        setOnClickListener(); /* 这一行必须摆在这里 不能摆在下面一段的下面*/

        RecyclerAdapter adapter = new RecyclerAdapter(project_list, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        dataBinding.recyclerview.setLayoutManager(layoutManager);
        dataBinding.recyclerview.setItemAnimator(new DefaultItemAnimator());
        dataBinding.recyclerview.setAdapter(adapter);
    }

    public void setOnClickListener() {
        listener = new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {

                String id = project_list.get(position).getId(); //获取到点击位置对应的id，进而访问
//                Toast.makeText(getApplicationContext(), "id: " + id, Toast.LENGTH_LONG).show();

                viewModel.getFsuData("1", String.valueOf(id), "1", "1", "SystemAdmin", "2");
            }
        };
    }


    @Override
    protected void getBack(Object obj) {
        finish();
    }

    @Override
    protected void getMenu(Object obj) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        dataBinding.setModel(this);
    }
}
