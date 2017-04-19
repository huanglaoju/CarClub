package cn.flyexp.carclub.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.flyexp.carclub.R;
import cn.flyexp.carclub.adapter.MainAdapter;
import cn.flyexp.carclub.assistview.DividerItemDecoration;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainAdapter.IOnItemClickListener {

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

    //适配器
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        //toolbar设置初始标题
        toolbar.setTitle(getResources().getString(R.string.app_name));
        //设置导航icon
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        //以上属性必须在setSupportActionBar(toolbar)之前调用
        setSupportActionBar(toolbar);

        //RecyclerView属性
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, true));//下划线
        //适配器
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

        toolbar.setNavigationOnClickListener(this);//监听导航icon点击事件
        mainAdapter.setOnItemClickListener(this);//列表item点击事件
    }

    @Override
    public void onClick(View view) {
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    @OnClick({R.id.user_name, R.id.user_icon, R.id.information, R.id.feedback, R.id.update, R.id.about, R.id.exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_name:
            case R.id.user_icon:

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
                Toast.makeText(this, getResources().getString(R.string.about), Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                System.exit(0);
                break;
        }
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

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show();
    }
}
