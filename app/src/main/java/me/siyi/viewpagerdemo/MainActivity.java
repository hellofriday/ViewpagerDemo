package me.siyi.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.siyi.viewpagerdemo.adapter.MainFragmentPageAdapter;
import me.siyi.viewpagerdemo.fragment.AFragment;
import me.siyi.viewpagerdemo.fragment.BFragment;
import me.siyi.viewpagerdemo.fragment.CFragment;
import me.siyi.viewpagerdemo.fragment.DFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.rbtn_main)
    RadioButton rbtnMain;
    @BindView(R.id.rbtn_current)
    RadioButton rbtnCurrentTask;
    @BindView(R.id.rbtn_history)
    RadioButton rbtnHistoryTask;
    @BindView(R.id.rbtn_personal)
    RadioButton rbtnPersonal;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        //viewpager加载数据
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());
        viewPager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), fragments));

        rbtnMain.setChecked(true);
        viewPager.addOnPageChangeListener(this);
    }

    @OnClick({R.id.rbtn_main, R.id.rbtn_current, R.id.rbtn_history, R.id.rbtn_personal})
    public void toLoadFragment(View view){
        switch (view.getId()){
            case R.id.rbtn_main:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rbtn_current:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rbtn_history:
                viewPager.setCurrentItem(2);
                break;
            case R.id.rbtn_personal:
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                rbtnMain.setChecked(true);
                break;
            case 1:
                rbtnCurrentTask.setChecked(true);
                break;
            case 2:
                rbtnHistoryTask.setChecked(true);
                break;
            case 3:
                rbtnPersonal.setChecked(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}





