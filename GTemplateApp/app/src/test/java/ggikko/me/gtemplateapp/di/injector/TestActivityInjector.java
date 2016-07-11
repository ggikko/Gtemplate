package ggikko.me.gtemplateapp.di.injector;

import ggikko.me.gtemplateapp.di.component.ActivityComponent;
import ggikko.me.gtemplateapp.di.component.TestActivityComponent;
import ggikko.me.gtemplateapp.ui.MainActivity;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;
import lombok.Getter;

/**
 * activity injector
 */
public class TestActivityInjector {

    @Getter
    private final TestActivityComponent activityComponent;

    public TestActivityInjector(TestActivityComponent activityComponent) {
        this.activityComponent = activityComponent;
    }

    public void inject(InjectionActivity activity) {
        if (activity instanceof MainActivity) activityComponent.inject((MainActivity) activity);

    }
}
