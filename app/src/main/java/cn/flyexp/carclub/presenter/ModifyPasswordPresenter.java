package cn.flyexp.carclub.presenter;

import cn.flyexp.carclub.activity.iview.IModifyPasswordView;
import cn.flyexp.carclub.base.BasePresenter;
import cn.flyexp.carclub.presenter.ipresenter.IModifyPasswordPresenter;

/**
 * Created by Won on 2017/4/19.
 */

public class ModifyPasswordPresenter extends BasePresenter<IModifyPasswordView> implements IModifyPasswordPresenter {

    /**
     * 获取验证码
     */
    @Override
    public void getSecurityCode() {

    }

    /**
     * 完成
     */
    @Override
    public void complete() {

    }


    @Override
    protected void onDestroy() {
        unsubscribe();
    }
}
