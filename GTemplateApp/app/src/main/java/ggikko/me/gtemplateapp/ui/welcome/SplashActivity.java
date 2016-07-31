package ggikko.me.gtemplateapp.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindString;
import butterknife.ButterKnife;
import ggikko.me.gtemplateapp.R;
import ggikko.me.gtemplateapp.ui.MainActivity;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;
import ggikko.me.gtemplateapp.util.network.ReactiveNetwork;
import rx.Subscription;

//TODO network status 바꾸기
public class SplashActivity extends InjectionActivity {

    private static String TAG = "ggikko";

    private ReactiveNetwork reactiveNetwork;
    private Subscription connectivitySubscription;

    private boolean NETWORKING_FLAG = true;
    private MaterialDialog dialog;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate() {
        unbinder = ButterKnife.bind(this);
        //version check
        versionCheck();
        //network check
        checkNetworkStatus();
    }

    /** version checking */
    private void versionCheck() {
        try {
            //TODO : check version from server or google store/package name .. VERSION NAME = MAJOR.MID.MINOR
            String device_version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            Log.e(TAG,"device_version : " + device_version);

            //TODO : Devide Id checking 100%보장할 수 없으므로.  Proyo 2.2 이전 Version 에는 100% 디바이스 고유 번호를 획득 한다고는 보장못함. 섞어봐야하나?
//            TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//            manager.getDeviceId();
//            String androidId = Settings.Secure.ANDROID_ID;
            String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** network checking */
    private void checkNetworkStatus() {
       if(isNetworkOn()){
           callNextStep();
       }
    }

    /** navigate another activity checking */
    private void callNextStep() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        NETWORKING_FLAG = true;
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(dialog!=null) dialog.dismiss();
    }
}
