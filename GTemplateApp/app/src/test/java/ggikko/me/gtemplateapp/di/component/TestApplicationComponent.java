package ggikko.me.gtemplateapp.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.di.module.ActivityModule;
import ggikko.me.gtemplateapp.di.module.ApplicationModule;
import ggikko.me.gtemplateapp.di.module.TestApplicationModule;
import ggikko.me.gtemplateapp.di.module.TestNetworkModule;
import ggikko.me.gtemplateapp.di.module.network.NetworkModule;

@Singleton
@Component(modules = {TestApplicationModule.class, TestNetworkModule.class})
public interface TestApplicationComponent extends ApplicationComponent {

    ActivityComponent plusActivityComponent(ActivityModule activityModule);

    void inject(GgikkoApplication application);
}
