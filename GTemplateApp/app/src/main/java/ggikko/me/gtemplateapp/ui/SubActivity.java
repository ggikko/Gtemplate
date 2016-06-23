package ggikko.me.gtemplateapp.ui;

import android.os.Bundle;

import butterknife.ButterKnife;
import ggikko.me.gtemplateapp.R;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;

public class SubActivity extends InjectionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        unbinder = ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
    }
}
