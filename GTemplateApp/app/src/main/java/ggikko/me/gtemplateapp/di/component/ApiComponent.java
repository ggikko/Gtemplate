package ggikko.me.gtemplateapp.di.component;

import dagger.Component;
import ggikko.me.gtemplateapp.di.module.network.ApiModule;
import ggikko.me.gtemplateapp.di.qualifier.PerActivity;
import ggikko.me.gtemplateapp.ui.MainActivity;

/**
 * Created by ggikko on 16. 5. 25..
 */
@PerActivity
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity mainActivity);
}
