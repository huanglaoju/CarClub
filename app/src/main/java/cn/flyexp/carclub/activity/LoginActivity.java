package cn.flyexp.carclub.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;
import cn.flyexp.carclub.R;
import cn.flyexp.carclub.activity.iview.ILoginView;
import cn.flyexp.carclub.base.BaseActivity;
import cn.flyexp.carclub.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<ILoginView, LoginPresenter> implements ILoginView, View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.id)
    MaterialEditText id;
    @BindView(R.id.password)
    MaterialEditText password;
    @BindView(R.id.register_id)
    TextView registerId;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //toolbar设置初始标题
        toolbar.setTitle(getResources().getString(R.string.login));
        toolbar.setTitleTextColor(getResources().getColor(R.color.color21));
        //设置导航icon
        toolbar.setNavigationIcon(R.drawable.ic_back_2);
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);

        //配置SwipeRefreshLayout
        swipeRefreshLayout.setEnabled(false);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        toolbar.setNavigationOnClickListener(this);//监听导航icon点击事件
    }

    @OnClick({R.id.register_id, R.id.forget_password})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.register_id:
                intent.setClass(this, RegisterActivity.class);
                break;
            case R.id.forget_password:
                intent.putExtra("ForgetPassword", getResources().getString(R.string.forget_password));
                intent.setClass(this, ModifyPasswordActivity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void showError() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showComplete() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
