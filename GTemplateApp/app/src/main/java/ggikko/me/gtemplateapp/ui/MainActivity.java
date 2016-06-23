package ggikko.me.gtemplateapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.gtemplateapp.R;
import ggikko.me.gtemplateapp.model.translate.service.TranslateService;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;

public class MainActivity extends InjectionActivity {

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



    }
}
