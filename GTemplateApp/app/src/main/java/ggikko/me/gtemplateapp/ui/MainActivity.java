package ggikko.me.gtemplateapp.ui;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ggikko.me.gtemplateapp.R;
import ggikko.me.gtemplateapp.model.translate.service.TranslateService;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;
import ggikko.me.gtemplateapp.ui.base.main.adapter.SectionsPagerAdapter;

public class MainActivity extends InjectionActivity {

    //sample
    @Inject TranslateService mTranslateService;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tabs) TabLayout tabLayout;

    @BindView(R.id.init_navigation_view) NavigationView init_navigation_view;
    @BindView(R.id.init_drawer_layout) DrawerLayout init_drawer_layout;
    @BindView(R.id.main_content)
    CoordinatorLayout main_content;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private float lastTranslate = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        initUi();
        initDrawer();

    }

    public void initUi() {
        setSupportActionBar(toolbar);
        setupTabs();
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.nav_btn_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setupTabs() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setCustomView(getCustomIcon(R.mipmap.ic_launcher));
        tabLayout.getTabAt(0).setText("");
        tabLayout.getTabAt(1).setCustomView(getCustomIcon(R.mipmap.ic_launcher, 100));
        tabLayout.getTabAt(1).setText("");
        tabLayout.getTabAt(2).setCustomView(getCustomIcon(R.mipmap.ic_launcher, 100));
        tabLayout.getTabAt(2).setText("");
        tabLayout.getTabAt(3).setCustomView(getCustomIcon(R.mipmap.ic_launcher, 100));
        tabLayout.getTabAt(3).setText("");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ImageView imageView = (ImageView) tab.getCustomView();
                imageView.getDrawable().mutate().setAlpha(255);
                viewPager.setCurrentItem(tab.getPosition(), true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ImageView imageView = (ImageView) tab.getCustomView();
                imageView.getDrawable().mutate().setAlpha(100);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private View getCustomIcon(int resId, int alpha){
        return getCustomIcon(AppCompatDrawableManager.get().getDrawable(tabLayout.getContext(), resId), alpha);
    }

    private View getCustomIcon(int resId){
        return getCustomIcon(AppCompatDrawableManager.get().getDrawable(tabLayout.getContext(), resId), 255);
    }

    private View getCustomIcon(Drawable icon, int alpha){
        ImageView imageView = (ImageView) getLayoutInflater().inflate(R.layout.custom_tab, null);
        imageView.setImageDrawable(icon);
        imageView.getDrawable().mutate().setAlpha(alpha);
        return imageView;
    }


    /** drawer item selection */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            //홈버튼
            case android.R.id.home:
                if (init_drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    init_drawer_layout.closeDrawer(GravityCompat.START);
                } else {
                    init_drawer_layout.openDrawer(GravityCompat.START);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initDrawer() {
        if (init_navigation_view != null) setupDrawerContent(init_navigation_view);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, init_drawer_layout, toolbar, R.string.ggikko_drawer_open, R.string.ggikko_drawer_close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                float moveFactor = (main_content.getWidth() * slideOffset)/4;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                {
                    main_content.setTranslationX(moveFactor);
                }
                else
                {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    main_content.startAnimation(anim);

                    lastTranslate = moveFactor;
                }
            }
        };

        init_drawer_layout.addDrawerListener(mActionBarDrawerToggle);
    }

    /** drawer item event listener */
    private void setupDrawerContent(NavigationView navigationView) {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                init_drawer_layout.closeDrawers();
                return true;
            }
        });
    }

}
