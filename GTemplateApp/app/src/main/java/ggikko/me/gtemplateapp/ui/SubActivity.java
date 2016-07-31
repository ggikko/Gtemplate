package ggikko.me.gtemplateapp.ui;

import butterknife.ButterKnife;
import ggikko.me.gtemplateapp.R;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;

public class SubActivity extends InjectionActivity {

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_sub;
    }

    @Override
    protected void onCreate() {
        unbinder = ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
    }
}
