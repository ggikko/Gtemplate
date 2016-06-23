package ggikko.me.gtemplateapp.di.component;

import javax.inject.Singleton;
import dagger.Component;
import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.di.module.ActivityModule;
import ggikko.me.gtemplateapp.di.module.ApplicationModule;

/**
 * Application component -> Activity component -> Fragment component
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    ActivityComponent plusActivityComponent(ActivityModule activityModule);

    void inject(GgikkoApplication application);
}
