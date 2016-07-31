package ggikko.me.gtemplateapp.ui.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.R;
import ggikko.me.gtemplateapp.di.injector.ActivityInjector;
import lombok.Getter;

/**
 * activity for injection, appcompat Activity
 */
public abstract class InjectionActivity extends AppCompatActivity {

    @BindString(R.string.network_popup1) String network_popup1;
    @BindString(R.string.network_popup2) String network_popup2;
    @BindString(R.string.network_popup3) String network_popup3;
    @BindString(R.string.network_popup4) String network_popup4;

    /** static constant */
    public static final String PARENT_EXTRA = "PARENT_EXTRA";

    /** connectivity connectivityManager */
    private ConnectivityManager connectivityManager;
    private boolean isNetworkOn = false;

    /** binder */
    private Unbinder baseUnbider;
    protected Unbinder unbinder;

    /** toolbar */
    @BindView(R.id.toolbar)
    @Nullable protected Toolbar toolbar;

    /** dialog */
    AlertDialog loadingDialog;
    boolean stopped = false;
    boolean dialogVisible;

    @Getter
    private ActivityInjector activityInjector;


    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract void onCreate();

    /**
     * onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //dagger injection
        inject();
        super.onCreate(savedInstanceState);
        //네트워크 체킹 register 등록
        registerNetworkCheckingReceiver();
        //set layout param
        setContentView(getLayoutRes());
        //call onCreate subActivity
        onCreate();
    }

    /**
     * network receiver registration
     */
    private void registerNetworkCheckingReceiver() {
        connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver, filter);
    }

    /**
     * life cycler
     * onResume
     */
    @Override
    protected void onResume() {
        stopped = false;
        super.onResume();
    }

    /**
     * life cycler
     * onDestroy
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(unbinder!=null) unbinder.unbind();
        if(baseUnbider!=null) baseUnbider.unbind();
        unregisterReceiver(networkReceiver);
    }

    /**
     * layout binding
     * view binding - Butter knife
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        baseUnbider = ButterKnife.bind(this);
    }

    /** inject */
    private void inject() {
        final GgikkoApplication application = ((GgikkoApplication) getApplication());
        activityInjector = application.getInjectorCreator().makeActivityInjector(this);
        activityInjector.inject(this);
    }

    /**
     * navi up
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    /** dialog */
    public void showLoading() {
        hideLoading();
        dialogVisible = true;

        buildNewLoadingDialog().show();
    }

    /** common progressbar hide */
    public void hideLoading() {
        Log.e("ggikko","hide");
        if (isDialogShowing()) {
            dialogVisible = false;

            try {
                if (loadingDialog != null) {
                    loadingDialog.dismiss();
                }
            } catch (IllegalArgumentException ignored) { }
        }
    }

    /** common progressbar checking */
    boolean isDialogShowing() {
        return dialogVisible;
    }

    /** common progressbar show */
    AlertDialog buildNewLoadingDialog() {
        loadingDialog = new AlertDialog.Builder(this)
                .setView(R.layout.dialog_loading)
                .setCancelable(false)
                .create();

        loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return loadingDialog;
    }

    /** common active checking */
    public boolean isActive() {
        return !stopped;
    }


    /**
     * hide keyboard
     */
    protected void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * textview kindof에 따라 text type bold, Italic, BoldItalic, Normal 선택 지정
     * @param kindof
     * @param textViews
     */
    public void setTextTypeBold(String kindof, TextView... textViews){
        if(kindof.equals("bold")) for(TextView textView : textViews) textView.setTypeface(null, Typeface.BOLD);
        if(kindof.equals("italic")) for(TextView textView : textViews) textView.setTypeface(null, Typeface.ITALIC);
        if(kindof.equals("bolditalic")) for(TextView textView : textViews) textView.setTypeface(null, Typeface.BOLD_ITALIC);
        if(kindof.equals("normal")) for(TextView textView : textViews) textView.setTypeface(null, Typeface.NORMAL);
    }

    // TODO : should make common module for navigating in BaseActivity

    /**
     * snack bar
     * @param view
     * @param messageResId
     * @param duration
     */
    protected void snack(View view, @StringRes int messageResId, @Snackbar.Duration int duration) {
        if (view != null) Snackbar.make(view, messageResId, duration).show();
    }

    /**
     * Toast with String ref
     * @param messageResId
     * @param duration
     */
    protected void toast(@StringRes int messageResId, int duration) {
        Toast.makeText(InjectionActivity.this, messageResId, duration).show();
    }

    /**
     * Toast with String
     * @param text
     * @param duration
     *
     */
    protected void toastText(String text, int duration) {
        Toast.makeText(InjectionActivity.this, text, duration).show();
    }

    /**
     * common onkeydown
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return true;
    }

    /**
     * network checking Receiver
     */
    private BroadcastReceiver networkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            if (isConnectedToNetwork(activeNetwork)) {
                isNetworkOn = true;
                if (isConnectedToWIFI(activeNetwork)) {
                    //Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                } else if (isConnectedToMobile(activeNetwork)) {
                    //Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
                }
            } else {
                isNetworkOn = false;
                new MaterialDialog.Builder(InjectionActivity.this).title(network_popup1).content(network_popup2).positiveText(network_popup3).negativeText(network_popup4)
                        .onPositive((dialog, action)->{startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));})
                        .onNegative((dialog, action)->{finish();})
                        .show();
            }
        }

        /**
         * 네트워크가 연결되있는지
         * @param activeNetwork
         * @return
         */
        private boolean isConnectedToNetwork(NetworkInfo activeNetwork) {
            return activeNetwork != null;
        }

        /**
         * 모바일 네트워크가 연결되어있는지
         * @param activeNetwork
         * @return
         */
        private boolean isConnectedToMobile(NetworkInfo activeNetwork) {
            return activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
        }

        /**
         *
         * @param activeNetwork
         * @return
         */
        private boolean isConnectedToWIFI(NetworkInfo activeNetwork) {
            return activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        }
    };

    public boolean isNetworkOn(){
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? true : false;
    }

}
