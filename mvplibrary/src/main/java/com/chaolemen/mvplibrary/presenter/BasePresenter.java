package com.chaolemen.mvplibrary.presenter;

import com.chaolemen.mvplibrary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends BaseView> {
    public V mView;

    private WeakReference<V> weakReference;

    //绑定视图层
    public void attachView(V view){
        weakReference=new WeakReference<V>(view);
        mView=weakReference.get();
    }

    //返回视图层对象
    public LifecycleProvider getLifecycle(){
        return (LifecycleProvider) mView;
    }

    //解除绑定
    public void destroyView(){
        if (weakReference!=null){
            weakReference.clear();
        }
    }

}
