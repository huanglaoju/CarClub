package cn.flyexp.carclub.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.OnClick;
import cn.flyexp.carclub.R;
import cn.flyexp.carclub.activity.iview.IRegisterView;
import cn.flyexp.carclub.base.BaseActivity;
import cn.flyexp.carclub.presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity<IRegisterView, RegisterPresenter> implements IRegisterView, View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.id)
    MaterialEditText id;
    @BindView(R.id.password)
    MaterialEditText password;
    @BindView(R.id.password_enter)
    MaterialEditText passwordEnter;
    @BindView(R.id.security_code)
    MaterialEditText securityCode;
    @BindView(R.id.get_security_code)
    TextView getSecurityCode;
    @BindView(R.id.agreement)
    TextView agreement;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected RegisterPresenter initPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        //toolbar设置初始标题
        toolbar.setTitle(getResources().getString(R.string.register));
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

    @OnClick({R.id.get_security_code, R.id.agreement, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get_security_code:
                Toast.makeText(this, "获取验证码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.register:
                Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.agreement:
                Toast.makeText(this, "协议", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showComplete() {

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
