package com.fish.ab.base.vm;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import com.fish.ab.app.vm.BaseTitleViewModel;
import com.fish.ab.base.bean.DialogBean;


/**
 * 项目名:    TODO-MVVM
 * 包名       com.azhon.basic.base
 * 文件名:    BaseActivity
 * 创建时间:  2019-03-27 on 10:46
 * 描述:     TODO ViewModel、ViewDataBinding都需要的基类
 *
 * @author 阿钟
 */

public abstract class BaseActivity<VM extends BaseViewModel, DB extends ViewDataBinding>
        extends BaseNoModelActivity<DB> {

    protected VM viewModel;
    public BaseTitleViewModel titleViewModel;

    @Override
    protected DB initDataBinding(int layoutId) {
        DB db = super.initDataBinding(layoutId);
        /**
         * 将这两个初始化函数插在{@link BaseActivity#initDataBinding}
         */
        viewModel = initViewModel();
        titleViewModel = initTitleVM();
        initObserve();
        return db;
    }

    /**
     * 初始化ViewModel
     */
    protected abstract VM initViewModel();

    /**
     * 初始化ViewModel
     *
     * @return
     */
    protected abstract BaseTitleViewModel initTitleVM();

    /**
     * 监听当前ViewModel中 showDialog和error的值
     */
    private void initObserve() {
        if (viewModel != null) {
            viewModel.getShowDialog(this, new Observer<DialogBean>() {
                @Override
                public void onChanged(DialogBean bean) {
                    if (bean.isShow()) {
                        showDialog(bean.getMsg());
                    } else {
                        dismissDialog();
                    }
                }
            });
            viewModel.getError(this, new Observer<Object>() {
                @Override
                public void onChanged(Object obj) {
                    showError(obj);
                }
            });
        }

        if (titleViewModel != null) {
            titleViewModel.getBack(this, new Observer<Object>() {
                @Override
                public void onChanged(Object obj) {
                    getBack(obj);
                }
            });
            titleViewModel.getMenu(this, new Observer<Object>() {
                @Override
                public void onChanged(Object obj) {
                    getMenu(obj);
                }
            });
        }
    }

    public void setTitle(String title) {
        if (titleViewModel != null) {
            titleViewModel.setTitle(title);
        }
    }

    public void showBack(boolean flag) {
        if (titleViewModel != null) {
            titleViewModel.backflag = flag;
        }
    }

    public void showMenu(boolean flag) {
        if (titleViewModel != null) {
            titleViewModel.menuflag = flag;
        }
    }

    /**
     * ViewModel层发生了错误
     */
    protected abstract void showError(Object obj);

    /**
     * ViewModel层发生了错误
     */
    protected abstract void getBack(Object obj);

    protected abstract void getMenu(Object obj);
}
