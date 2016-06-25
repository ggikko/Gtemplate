package ggikko.me.gtemplateapp.ui.welcome;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindString;
import ggikko.me.gtemplateapp.R;
import ggikko.me.gtemplateapp.ui.MainActivity;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;
import ggikko.me.gtemplateapp.util.network.ReactiveNetwork;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashActivity extends InjectionActivity {

    private ReactiveNetwork reactiveNetwork;
    private Subscription connectivitySubscription;

    private boolean NETWORKING_FLAG = true;
    private MaterialDialog dialog;

    @BindString(R.string.splash_popup1) String splash_popup1;
    @BindString(R.string.splash_popup2) String splash_popup2;
    @BindString(R.string.splash_popup3) String splash_popup3;
    @BindString(R.string.splash_popup4) String splash_popup4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkNetworkStatus();
    }

    private void checkNetworkStatus() {
        reactiveNetwork = new ReactiveNetwork();

        //TODO : 비효율적인 구조 개선필요
        connectivitySubscription = new ReactiveNetwork().observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isConnectedToInternet -> {
                    if (NETWORKING_FLAG) {
                        if (isConnectedToInternet) {
                            NETWORKING_FLAG = false;
                            callNextStep();
                        } else {
                            /** networking dialog */
                            dialog = new MaterialDialog.Builder(SplashActivity.this).title(splash_popup1).content(splash_popup2).positiveText(splash_popup3).negativeText(splash_popup4)
                                    .onPositive((dialog, action)->{startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));})
                                    .onNegative((dialog, action)->{finish();})
                                    .show();
                        }
                    }
                });
    }


    private void callNextStep() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        NETWORKING_FLAG = true;
        finish();
    }
}
