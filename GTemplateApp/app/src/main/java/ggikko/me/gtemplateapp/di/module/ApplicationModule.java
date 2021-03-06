package ggikko.me.gtemplateapp.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.util.auth.AuthorizationUtil;

/**
 * Application module
 * TODO : Realm etc
 */
@Module
public class ApplicationModule {
    private final GgikkoApplication application;

    public ApplicationModule(GgikkoApplication application) {
        this.application = application;
    }

    /**
     * Provide App Context
     * @return
     */
    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    /**
     * Provice resource
     * @return
     */
    @Provides
    @Singleton
    Resources provideResources() {
        return application.getResources();
    }

    /**
     * sharedPref
     * @return
     */
    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs(){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    /**
     * Authorization util
     * @param sharedPreferences
     * @return
     */
    @Provides
    @Singleton
    AuthorizationUtil provideAuthorizationChecking(SharedPreferences sharedPreferences){
        return new AuthorizationUtil(sharedPreferences);
    }
}
