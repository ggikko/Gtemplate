package ggikko.me.gtemplateapp.di.component;

import dagger.Subcomponent;
import ggikko.me.gtemplateapp.di.module.ActivityModule;
import ggikko.me.gtemplateapp.di.module.FragmentModule;
import ggikko.me.gtemplateapp.di.module.network.ApiModule;
import ggikko.me.gtemplateapp.di.module.network.NetworkModule;
import ggikko.me.gtemplateapp.di.qualifier.PerActivity;
import ggikko.me.gtemplateapp.ui.MainActivity;
import retrofit2.Retrofit;

@PerActivity
@Subcomponent(modules = {ActivityModule.class, ApiModule.class})
public interface ActivityComponent {

    FragmentComponent plusFragmentComponent(FragmentModule module);

    void inject(MainActivity activity);

}
