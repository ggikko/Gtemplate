package ggikko.me.gtemplateapp.di.injector;

import ggikko.me.gtemplateapp.di.component.ActivityComponent;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;
import ggikko.me.gtemplateapp.ui.MainActivity;
import lombok.Getter;

public class ActivityInjector {

    @Getter
    private final ActivityComponent activityComponent;

    public ActivityInjector(ActivityComponent activityComponent) {
        this.activityComponent = activityComponent;
    }

    public void inject(InjectionActivity activity) {
        if (activity instanceof MainActivity) activityComponent.inject((MainActivity) activity);

    }
}
