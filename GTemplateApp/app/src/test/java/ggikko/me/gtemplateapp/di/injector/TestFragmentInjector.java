package ggikko.me.gtemplateapp.di.injector;

import ggikko.me.gtemplateapp.di.component.FragmentComponent;
import ggikko.me.gtemplateapp.di.component.TestFragmentComponent;
import ggikko.me.gtemplateapp.ui.base.InjectionFragment;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * fragment injector
 */
public class TestFragmentInjector {

    @Getter(value = AccessLevel.PACKAGE)
    private final TestFragmentComponent fragmentComponent;

    public TestFragmentInjector(TestFragmentComponent fragmentComponent) {
        this.fragmentComponent = fragmentComponent;
    }

    public void inject(InjectionFragment fragment) {

    }
}
