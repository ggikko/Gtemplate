package ggikko.me.gtemplateapp.di.injector;

import ggikko.me.gtemplateapp.GgikkoApplication;
import ggikko.me.gtemplateapp.di.component.ActivityComponent;
import ggikko.me.gtemplateapp.di.component.ApplicationComponent;
import ggikko.me.gtemplateapp.di.component.DaggerApplicationComponent;
import ggikko.me.gtemplateapp.di.component.FragmentComponent;
import ggikko.me.gtemplateapp.di.module.ActivityModule;
import ggikko.me.gtemplateapp.di.module.ApplicationModule;
import ggikko.me.gtemplateapp.di.module.FragmentModule;
import ggikko.me.gtemplateapp.ui.base.InjectionActivity;

public class InjectorCreator {

    private ApplicationComponent applicationComponent;

    public ApplicationInjector makeApplicationInjector(GgikkoApplication application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .build();
        return new ApplicationInjector(applicationComponent);
    }

    public ActivityInjector makeActivityInjector(InjectionActivity activity) {
        final ActivityComponent activityComponent = applicationComponent.plusActivityComponent(new ActivityModule(activity));
        return new ActivityInjector(activityComponent);
    }

    public FragmentInjector makeFragmentInjector(InjectionFragment fragment) {
        final ActivityInjector activityInjector = ((InjectionActivity) fragment.getActivity()).getActivityInjector();
        final FragmentComponent fragmentComponent = activityInjector.getActivityComponent().plusFragmentComponent(new FragmentModule(fragment));
        return new FragmentInjector(fragmentComponent);
    }
}
