package ggikko.me.gtemplateapp.di.component;

import dagger.Subcomponent;
import ggikko.me.gtemplateapp.di.module.ActivityModule;
import ggikko.me.gtemplateapp.di.module.FragmentModule;
import ggikko.me.gtemplateapp.di.qualifier.PerActivity;
import ggikko.me.gtemplateapp.ui.MainActivity;

@PerActivity
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    FragmentComponent plusFragmentComponent(FragmentModule module);

    void inject(MainActivity activity);
}
