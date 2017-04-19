package cn.flyexp.carclub.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.aitangba.swipeback.SwipeBackActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.flyexp.carclub.R;

public class AboutActivity extends SwipeBackActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        //toolbar设置初始标题
        toolbar.setTitle(getResources().getString(R.string.about));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        //设置导航icon
        toolbar.setNavigationIcon(R.drawable.ic_back);
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(this);//监听导航icon点击事件
    }

    @OnClick({R.id.about_us, R.id.use_term, R.id.privacy_policy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.about_us:
                Toast.makeText(this, "关于我们", Toast.LENGTH_SHORT).show();
                break;
            case R.id.use_term:
                Toast.makeText(this, "使用条款", Toast.LENGTH_SHORT).show();
                break;
            case R.id.privacy_policy:
                Toast.makeText(this, "隐私政策", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
