package com.chaolemen.ergedd;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.chaolemen.ergedd.download.DownloadFragment;
import com.chaolemen.ergedd.hear.HearFragment;
import com.chaolemen.ergedd.look.LookFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Toolbar mMainToolbar;
    private FrameLayout mMainFrame;
    private TabLayout mMainTabLayout;

//    @BindView(R.id.toolbar_main)
//    Toolbar mToolbarMain;
//    @BindView(R.id.frame_main)
//    FrameLayout mFrameMain;
//    @BindView(R.id.tabLayout_main)
//    TabLayout mTabLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        ButterKnife.bind(this);
    }


    private void initView() {

        mMainToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mMainFrame = (FrameLayout) findViewById(R.id.frame_main);
        mMainTabLayout = (TabLayout) findViewById(R.id.tabLayout_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        final LookFragment lookFragment = new LookFragment();
        final HearFragment hearFragment = new HearFragment();
        final DownloadFragment downloadFragment = new DownloadFragment();

        fragmentManager.beginTransaction()
                .add(R.id.frame_main, lookFragment)
                .add(R.id.frame_main, hearFragment)
                .add(R.id.frame_main, downloadFragment)
                .hide(hearFragment)
                .hide(downloadFragment)
                .commit();
        mMainTabLayout.addTab(mMainTabLayout.newTab().setIcon(R.drawable.select_look).setText("宝宝看"));
        mMainTabLayout.addTab(mMainTabLayout.newTab().setIcon(R.drawable.select_hear).setText("宝宝听"));
        mMainTabLayout.addTab(mMainTabLayout.newTab().setIcon(R.drawable.select_download).setText("下载"));


        mMainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragmentManager.beginTransaction()
                                .show(lookFragment)
                                .hide(hearFragment)
                                .hide(downloadFragment)
                                .commit();
                        break;
                    case 1:
                        fragmentManager.beginTransaction()
                                .hide(lookFragment)
                                .show(hearFragment)
                                .hide(downloadFragment)
                                .commit();
                        break;
                    case 2:
                        fragmentManager.beginTransaction()
                                .hide(lookFragment)
                                .hide(hearFragment)
                                .show(downloadFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    protected void initData() {

    }
}
