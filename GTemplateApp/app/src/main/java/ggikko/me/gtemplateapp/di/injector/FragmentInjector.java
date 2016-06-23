package ggikko.me.gtemplateapp.di.injector;

import ggikko.me.gtemplateapp.di.component.FragmentComponent;
import lombok.AccessLevel;
import lombok.Getter;

public class FragmentInjector {

    @Getter(value = AccessLevel.PACKAGE)
    private final FragmentComponent fragmentComponent;

    public FragmentInjector(FragmentComponent fragmentComponent) {
        this.fragmentComponent = fragmentComponent;
    }

    public void inject(InjectionFragment fragment) {

    }
}
