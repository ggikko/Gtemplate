package ggikko.me.gtemplateapp.di.injector;

import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.di.component.ApplicationComponent;
import lombok.Getter;

public class ApplicationInjector {

    @Getter
    private final ApplicationComponent applicationComponent;

    public ApplicationInjector(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public void inject(GgikkoApplication application) {
        applicationComponent.inject(application);
    }
}
