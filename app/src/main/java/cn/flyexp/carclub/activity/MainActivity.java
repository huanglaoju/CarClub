package cn.flyexp.carclub.activity;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.flyexp.carclub.R;
import cn.flyexp.carclub.activity.iview.IMainView;
import cn.flyexp.carclub.adapter.MainAdapter;
import cn.flyexp.carclub.assistview.DividerItemDecoration;
import cn.flyexp.carclub.base.BaseActivity;
import cn.flyexp.carclub.presenter.MainPresenter;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity<IMainView, MainPresenter> implements IMainView, View.OnClickListener, MainAdapter.IOnItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_icon)
    CircleImageView userIcon;
    @BindView(R.id.version)
    TextView version;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    //适配器
    private MainAdapter mainAdapter;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //toolbar设置初始标题
        toolbar.setTitle(getResources().getString(R.string.app_name));
        //设置导航icon
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);

        //配置SwipeRefreshLayout
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        //RecyclerView属性
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, true));//下划线
        //适配器
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

        toolbar.setNavigationOnClickListener(this);//监听导航icon点击事件
        swipeRefreshLayout.setOnRefreshListener(this);//监听下拉刷新
        mainAdapter.setOnItemClickListener(this);//列表item点击事件
    }

    @Override
    public void onClick(View view) {
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    @OnClick({R.id.user_name, R.id.user_icon, R.id.information, R.id.feedback, R.id.update, R.id.about, R.id.exit})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.user_name:
            case R.id.user_icon:
                intent.setClass(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.information:
                Toast.makeText(this, getResources().getString(R.string.information), Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback:
                Toast.makeText(this, getResources().getString(R.string.feedback), Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
                Toast.makeText(this, getResources().getString(R.string.update), Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                intent.setClass(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.exit:
                System.exit(0);
                break;
        }
        drawerLayout.closeDrawers();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        presenter.loadData();
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void showEmpty() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showComplete(ArrayList<?> models) {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * 重写返回
     */
    @Override
    public void onBackPressed() {
        showQuitTips();
    }

    private long firstPressTime = -1;// 记录第一次按下的时间
    private long lastPressTime;// 记录第二次按下的时间

    /**
     * 双击返回退出
     */
    private void showQuitTips() {
        // 如果是第一次按下 直接提示
        if (firstPressTime == -1) {
            firstPressTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
        }
        // 如果是第二次按下，需要判断与上一次按下的时间间隔，这里设置2秒
        else {
            lastPressTime = System.currentTimeMillis();
            if (lastPressTime - firstPressTime <= 2000) {
                System.exit(0);
            } else {
                firstPressTime = lastPressTime;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 重写SlideBack方法
     * 返回false表示不支持滑动返回
     */
    @Override
    public boolean supportSlideBack() {
        return false;
    }

}
