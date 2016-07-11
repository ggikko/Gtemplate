package ggikko.me.gtemplateapp.di.injector;

import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.di.component.ApplicationComponent;
import ggikko.me.gtemplateapp.di.component.TestApplicationComponent;
import lombok.Getter;

public class TestApplicationInjector {

    @Getter
    private final TestApplicationComponent applicationComponent;

    public TestApplicationInjector(TestApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public void inject(GgikkoApplication application) {
        applicationComponent.inject(application);
    }
}
