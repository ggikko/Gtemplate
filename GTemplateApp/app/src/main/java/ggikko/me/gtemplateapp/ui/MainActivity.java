package ggikko.me.gtemplateapp.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.gtemplateapp.R;
import ggikko.me.gtemplateapp.model.translate.service.TranslateService;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;

public class MainActivity extends InjectionActivity {

//    @BindView(R.id.init_navigation_view) NavigationView init_navigation_view;
//    @BindView(R.id.init_drawer_layout) DrawerLayout init_drawer_layout;
//    @BindView(R.id.init_toolbar) Toolbar init_toolbar;
//    private ActionBarDrawerToggle mActionBarDrawerToggle;
//    private float lastTranslate = 0.0f;

    //sample
    @Inject TranslateService mTranslateService;

    @OnClick({R.id.next})
    void callOnClick(View view){
        switch (view.getId()){
            case R.id.next :
                startActivity(new Intent(MainActivity.this, SubActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        setSupportActionBar(toolbar);


//        if (init_navigation_view != null) setupDrawerContent(init_navigation_view);
//        //drawer slide animation
//        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, init_drawer_layout, init_toolbar, R.string.acc_drawer_open, R.string.acc_drawer_close){
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                float moveFactor = (invest_list_content.getWidth() * slideOffset)/4;
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
//                {
//                    invest_list_content.setTranslationX(moveFactor);
//                }
//                else
//                {
//                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
//                    anim.setDuration(0);
//                    anim.setFillAfter(true);
//                    invest_list_content.startAnimation(anim);
//
//                    lastTranslate = moveFactor;
//                }
//            }
//        };
//
//        init_drawer_layout.addDrawerListener(mActionBarDrawerToggle);
    }

    /** drawer item event listener */
//    private void setupDrawerContent(NavigationView navigationView) {
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem menuItem) {
//                menuItem.setChecked(true);
//                switch (menuItem.getItemId()) {
//                }
//                init_drawer_layout.closeDrawers();
//                return true;
//            }
//        });
//    }
}
