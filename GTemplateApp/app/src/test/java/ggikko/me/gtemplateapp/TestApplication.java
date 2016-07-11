package ggikko.me.gtemplateapp;

import android.support.annotation.VisibleForTesting;


import ggikko.me.gtemplateapp.di.injector.InjectorCreator;
import ggikko.me.gtemplateapp.di.injector.TestInjectorCreator;

/**
 * Created by admin on 16. 7. 11..
 */
public class TestApplication extends GgikkoApplication {


    @VisibleForTesting
    protected InjectorCreator makeInjectorCreator() {
        return new TestInjectorCreator();
    }

    @VisibleForTesting
    public void changeInjectorCreator(InjectorCreator injectorCreator) {
        this.injectorCreator = injectorCreator;
        inject();
    }
}
