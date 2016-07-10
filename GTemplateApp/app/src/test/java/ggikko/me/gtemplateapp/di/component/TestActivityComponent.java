package ggikko.me.gtemplateapp.di.component;

import com.bumptech.glide.module.GlideModule;

import dagger.Subcomponent;
import ggikko.me.gtemplateapp.di.module.ActivityModule;
import ggikko.me.gtemplateapp.di.module.FragmentModule;
import ggikko.me.gtemplateapp.di.module.network.ApiModule;
import ggikko.me.gtemplateapp.di.qualifier.PerActivity;
import ggikko.me.gtemplateapp.ui.MainActivity;

@PerActivity
@Subcomponent(modules = {ActivityModule.class, ApiModule.class})
public interface TestActivityComponent extends ActivityComponent {

    TestFragmentComponent plusTestFragmentComponent(FragmentModule module);

    void inject(MainActivity activity);
}
