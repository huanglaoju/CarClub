package cn.flyexp.carclub.presenter;

import android.app.Activity;

import cn.flyexp.carclub.activity.iview.IMainView;
import cn.flyexp.carclub.base.BasePresenter;
import cn.flyexp.carclub.presenter.ipresenter.IMainPresenter;

/**
 * Created by Won on 2017/4/19.
 */

public class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {

    /**
     * 加载数据
     */
    @Override
    public void loadData() {
        mView.showLoading();
        final Activity activity = (Activity) context;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.showEmpty();
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        unsubscribe();
    }
}
