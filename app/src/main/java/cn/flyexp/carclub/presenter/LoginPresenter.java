package cn.flyexp.carclub.presenter;

import cn.flyexp.carclub.activity.iview.ILoginView;
import cn.flyexp.carclub.base.BasePresenter;
import cn.flyexp.carclub.presenter.ipresenter.ILoginPresenter;

/**
 * Created by Won on 2017/4/19.
 */

public class LoginPresenter extends BasePresenter<ILoginView> implements ILoginPresenter {

    /**
     * 登录
     */
    @Override
    public void login() {

    }

    @Override
    protected void onDestroy() {
        unsubscribe();
    }
}
