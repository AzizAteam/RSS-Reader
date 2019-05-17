package com.example.rssreader.Controllers.Activities;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rssreader.Controllers.Fragments.HomeFragment;
import com.example.rssreader.Controllers.Fragments.ReadLaterFragment;
import com.example.rssreader.Controllers.Fragments.SettingsFragment;
import com.example.rssreader.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private HomeFragment mHomeFragment;
    private SettingsFragment mSettingsFragment;
    private ReadLaterFragment mReadLaterFragment;
    @BindView(R.id.activity_main_bottom_navigation)
    BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        showFirstFragment();
        configureBottomView();
    }

    private void configureBottomView() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> updateFragment(item.getItemId()));
    }

    private Boolean updateFragment(Integer integer) {
        switch (integer) {
            case R.id.action_readlater:
                this.showReadLaterFragment();
                break;
            case R.id.action_home:
                this.showHomeFragment();
                break;
            case R.id.action_setting:
                this.showSettingsFragment();
                break;
            default:
                HomeFragment.newInstance();
        }
        return true;
    }

    private void startTransactionFragment(Fragment fragment) {
        if (!fragment.isVisible()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_frame_layout, fragment).commit();
        }
    }


    public void showFirstFragment() {
        Fragment visibleFragment = getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);
        if (visibleFragment == null) {
            this.showHomeFragment();
            this.mBottomNavigationView.getMenu().getItem(1).setChecked(true);

        }
    }

    private void showReadLaterFragment() {
        if (this.mReadLaterFragment == null)
            this.mReadLaterFragment = ReadLaterFragment.newInstance();
        this.startTransactionFragment(this.mReadLaterFragment);
    }

    private void showHomeFragment() {
        if (this.mHomeFragment == null) this.mHomeFragment = HomeFragment.newInstance();
        this.startTransactionFragment(this.mHomeFragment);
    }

    private void showSettingsFragment() {
        if (this.mSettingsFragment == null)
            this.mSettingsFragment = SettingsFragment.newInstance();
        this.startTransactionFragment(this.mSettingsFragment);
    }
}
