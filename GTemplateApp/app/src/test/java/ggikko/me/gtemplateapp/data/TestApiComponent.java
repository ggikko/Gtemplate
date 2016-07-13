package ggikko.me.gtemplateapp.data;

import dagger.Component;
import ggikko.me.gtemplateapp.data.translate.TestTranslateService;
import ggikko.me.gtemplateapp.di.component.NetworkComponent;
import ggikko.me.gtemplateapp.di.module.network.ApiModule;
import ggikko.me.gtemplateapp.di.qualifier.PerActivity;
import ggikko.me.gtemplateapp.ui.MainActivity;

/**
 * Created by ggikko on 16. 5. 25..
 */
@PerActivity
@Component(modules = ApiModule.class, dependencies = TestNetworkComponent.class)
public interface TestApiComponent {

    void inject(TestTranslateService testTranslateService);
}
