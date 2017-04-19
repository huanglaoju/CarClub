package cn.flyexp.carclub.presenter;

import cn.flyexp.carclub.activity.iview.IRegisterView;
import cn.flyexp.carclub.base.BasePresenter;
import cn.flyexp.carclub.presenter.ipresenter.IRegisterPresenter;

/**
 * Created by Won on 2017/4/19.
 */

public class RegisterPresenter extends BasePresenter<IRegisterView> implements IRegisterPresenter {

    /**
     * 获取验证码
     */
    @Override
    public void getSecurityCode() {

    }

    /**
     * 注册
     */
    @Override
    public void register() {

    }

    @Override
    protected void onDestroy() {
        unsubscribe();
    }
}
