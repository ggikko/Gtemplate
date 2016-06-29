package ggikko.me.gtemplateapp.ui.base;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import javax.inject.Inject;

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
public class InjectionActivity extends AppCompatActivity {

    /** static constant */
    public static final String PARENT_EXTRA = "PARENT_EXTRA";

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

    //life cycler in activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inject();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        stopped = false;
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(unbinder!=null) unbinder.unbind();
        if(baseUnbider!=null) baseUnbider.unbind();
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        baseUnbider = ButterKnife.bind(this);
    }

    private void inject() {
        final GgikkoApplication application = ((GgikkoApplication) getApplication());
        activityInjector = application.getInjectorCreator().makeActivityInjector(this);
        activityInjector.inject(this);
    }

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

    boolean isDialogShowing() {
        return dialogVisible;
    }

    AlertDialog buildNewLoadingDialog() {
        loadingDialog = new AlertDialog.Builder(this)
                .setView(R.layout.dialog_loading)
                .setCancelable(false)
                .create();

        loadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return loadingDialog;
    }

    public boolean isActive() {
        return !stopped;
    }

}
