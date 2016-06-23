package ggikko.me.gtemplateapp.di.module;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;
import ggikko.me.gtemplateapp.di.qualifier.PerActivity;

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    Context provideActivityContext() {
        return activity;
    }

    @Provides
    @PerActivity
    LayoutInflater provideLayoutInflater() {
        return activity.getLayoutInflater();
    }
}
