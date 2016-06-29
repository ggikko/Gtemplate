package ggikko.me.gtemplateapp.di.injector;

import ggikko.me.gtemplateapp.di.component.FragmentComponent;
import ggikko.me.gtemplateapp.ui.base.InjectionFragment;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * fragment injector
 */
public class FragmentInjector {

    @Getter(value = AccessLevel.PACKAGE)
    private final FragmentComponent fragmentComponent;

    public FragmentInjector(FragmentComponent fragmentComponent) {
        this.fragmentComponent = fragmentComponent;
    }

    public void inject(InjectionFragment fragment) {

    }
}
