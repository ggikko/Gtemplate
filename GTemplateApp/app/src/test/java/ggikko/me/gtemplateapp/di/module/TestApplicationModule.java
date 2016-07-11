package ggikko.me.gtemplateapp.di.module;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ggikko.me.gtemplateapp.GgikkoApplication;


@Module
public class TestApplicationModule {
    private final GgikkoApplication application;

    public TestApplicationModule(GgikkoApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return application.getResources();
    }
}
