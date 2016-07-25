package ggikko.me.gtemplateapp.di.component;

import javax.inject.Singleton;
import dagger.Component;
import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.di.module.ActivityModule;
import ggikko.me.gtemplateapp.di.module.ApplicationModule;
import ggikko.me.gtemplateapp.di.module.network.NetworkModule;

/**
 * Application component -> Activity component -> Fragment component
 * 순서대로 주입
 * Qulifier에 따른 분할
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    ActivityComponent plusActivityComponent(ActivityModule activityModule);

    void inject(GgikkoApplication application);
}
